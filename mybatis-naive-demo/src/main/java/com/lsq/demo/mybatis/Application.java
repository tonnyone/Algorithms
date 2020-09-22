package com.lsq.demo.mybatis;


import com.lsq.demo.mybatis.dao.ICityDao;
import com.lsq.demo.mybatis.domain.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {

        Properties properties = new Properties();
        InputStream resourceAsStream = Application.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resource = "mybatis-config.xml";
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(resource); //拿到资源
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICityDao cityDao = session.getMapper(ICityDao.class);
            City city = cityDao.selectById(1L);
            System.out.println(city.getName());
        }

    }
}
