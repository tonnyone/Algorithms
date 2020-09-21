package com.lsq.demo.mapper;

import com.lsq.demo.model.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void findByNameTest(){
        City san_francisco = cityMapper.findByName("San Francisco");
        assertSame(san_francisco.getId(),1L);
    }
}
