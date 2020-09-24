package com.lsq.demo.mapper;

import com.lsq.demo.model.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void insert(){
        City city = new City();
        city.setName("北京");
        cityMapper.insert(city);
        assertSame(2L,city.getId());
    }

    @Test
    public void deleteById(){

        cityMapper.deleteById(1L);
        City city = cityMapper.findByName("旧金山");
        assertNull(city);
    }

    @Test
    public void findByNameTest(){
        City san_francisco = cityMapper.findByName("旧金山");
        assertSame(1L,san_francisco.getId());
    }


}
