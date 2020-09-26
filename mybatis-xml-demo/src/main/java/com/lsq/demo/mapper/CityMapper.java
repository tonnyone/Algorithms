package com.lsq.demo.mapper;

import com.lsq.demo.model.City;

import java.util.List;
import java.util.Map;

public interface CityMapper {

    void insert(City city);

    Long deleteById(Long id);

    Long updateById(City city);

    City findByName(String name);

    Integer count();

    void insertBatch(List<City> cites);

    City findById(Long id);

    Map<String,Object> findMapById(Long id);

    void deleteAll();
}
