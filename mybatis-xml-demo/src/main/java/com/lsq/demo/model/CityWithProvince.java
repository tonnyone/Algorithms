package com.lsq.demo.model;

import java.util.Date;

public class CityWithProvince {

    private Long id;
    private String name;
    private CityTypeEnum region;
    private Date insertTime;
    private Long provinceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityTypeEnum getRegion() {
        return region;
    }

    public void setRegion(CityTypeEnum region) {
        this.region = region;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
