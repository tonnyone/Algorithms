package com.lsq.demo.model;

public enum RegionEnum {

    NORTH(1,"华北"),NOTRHEAST(1,"东北");
    private Integer code;
    private String remark;

    RegionEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }

}
