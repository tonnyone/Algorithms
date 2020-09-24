package com.lsq.demo.mapper;

import com.lsq.demo.model.City;

public interface CityMapper {

    City findByName(String name);

    void insert(City city);

    Long deleteById(Long id);
}
