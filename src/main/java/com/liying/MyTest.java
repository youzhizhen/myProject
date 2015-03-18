package com.liying;

import com.liying.util.annotation.MapperCell;


public class MyTest {
    @MapperCell(cellName = "名称", order = 1)
    private String name;

    @MapperCell(cellName = "联系电话",order = 2)
    private String phone;

    @MapperCell(cellName = "地址", order = 3)
    private String address;

    @MapperCell(cellName = "一级分类ID", order = 4)
    private int type;

    @MapperCell(cellName = "经度", order = 5)
    private double lat;

    @Override
    public String toString() {
        return "name: " + name + "\t phone: " + phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
