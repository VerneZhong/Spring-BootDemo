package com.example.designpattern.compositemode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

public class DuckFlock implements Quackable {

    private ArrayList<Quackable> duckList = Lists.newArrayList();

    @Override
    public void quack() {
        Iterator<Quackable> quackableIterator = duckList.iterator();
        while (quackableIterator.hasNext()) {
            quackableIterator.next().quack();
        }
    }

    public void add(Quackable duck) {
        duckList.add(duck);
    }
}
