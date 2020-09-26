package com.lsq.demo.mapper;

import com.lsq.demo.model.City;
import com.lsq.demo.model.CityTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @BeforeEach
    private void initDatabase(){
        cityMapper.deleteAll();
        City city = new City();
        city.setName("北京");
        city.setType(CityTypeEnum.MAIN);
        city.setInsertTime(new Date());
        cityMapper.insert(city);

        City city2 = new City();
        city2.setName("天津");
        city2.setType(CityTypeEnum.COMMON);
        city2.setInsertTime(new Date());
        cityMapper.insert(city2);

        City city3 = new City();
        city3.setName("旧金山");
        city3.setType(CityTypeEnum.COMMON);
        city3.setInsertTime(new Date());
        cityMapper.insert(city3);
    }

    @Test
    public void insertTest() {
        City city = new City();
        city.setName("北京2");
        city.setType(CityTypeEnum.MAIN);
        city.setInsertTime(new Date());
        cityMapper.insert(city);
        assertNotNull(cityMapper.findByName("北京2"));
    }

    @Test
    public void deleteByIdTest() {

        City city = cityMapper.findByName("北京");
        cityMapper.deleteById(city.getId());
        assertNull(cityMapper.findByName("北京"));
    }

    @Test
    public void updateByIdTest(){
        City city = cityMapper.findByName("旧金山");
        city.setName("旧金山2");
        Long aLong = cityMapper.updateById(city);
        assertNotNull(cityMapper.findByName("旧金山2"));
    }

    @Test
    public void findByNameTest() {
        City san_francisco = cityMapper.findByName("北京");
        assertSame("北京", san_francisco.getName());
    }

    @Test
    public void insertBatch() {
        City city = new City();
        city.setName("天津");
        city.setType(CityTypeEnum.MAIN);
        city.setInsertTime(new Date());

        City city2 = new City();
        city2.setName("上海");
        city2.setType(CityTypeEnum.COMMON);
        city2.setInsertTime(new Date());

        List<City> list = new ArrayList();
        list.add(city);
        list.add(city2);
        cityMapper.insertBatch(list);
        assertSame(5, cityMapper.count());
    }

    @Test
    public void findByIdTest() {
        City city = cityMapper.findByName("北京");
        City beijing = cityMapper.findById(city.getId());
        assertSame(city.getId(), beijing.getId());
    }

    @Test
    public void findMapByIdTest() {
        City city = cityMapper.findByName("北京");
        Map<String, Object> map = cityMapper.findMapById(city.getId());
        assertEquals("北京",(String)map.get("NAME"));
    }


}
