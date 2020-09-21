package com.lsq.demo.mapper;

import com.lsq.demo.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM CITY WHERE name = #{name}")
    City findByName(@Param("name") String state);

}
