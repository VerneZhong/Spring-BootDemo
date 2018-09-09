package com.example.designpattern.combinationmode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuCompent {

    private ArrayList<MenuCompent> arrayList;

    private String name;
    private String desc;

    public Menu() {
    }

    public Menu(String name, String desc) {
        this.arrayList = Lists.newArrayList();
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void add(MenuCompent menuCompent) {
        this.arrayList.add(menuCompent);
    }

    @Override
    public void remove(MenuCompent menuCompent) {
        this.arrayList.remove(menuCompent);
    }

    @Override
    public MenuCompent getChild(int i) {
        return this.arrayList.get(i);
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
    public void print() {
        System.out.println("\n" + this.name);
        System.out.println("\n" + this.desc);
        System.out.println("--------------");
        Iterator<MenuCompent> iterator = this.arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    @Override
    public Iterator<MenuCompent> createIterator() {
        return new CompositeIterator(this.arrayList.iterator());
    }
}
