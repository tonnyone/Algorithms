package com.lsq.demo.mybatis.dao;

import com.lsq.demo.mybatis.domain.City;

public interface ICityDao {

    City selectById(Long id);
}
