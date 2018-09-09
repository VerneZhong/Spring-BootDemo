package com.example.designpattern.combinationmode;

import com.example.demo.common.JsonUtil;

import java.util.Iterator;

public class MenuItem extends MenuCompent {

    private String name;
    private String desc;
    private double price;
    private boolean vegetarian;

    public MenuItem() {
    }

    public MenuItem(String name, String desc, double price, boolean vegetarian) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean isVegetarian() {
        return this.vegetarian;
    }

    @Override
    public void print() {
        System.out.println(JsonUtil.getInstance().toJson(this));
    }

    @Override
    public Iterator<MenuCompent> createIterator() {
        return new NullIterator();
    }
}
