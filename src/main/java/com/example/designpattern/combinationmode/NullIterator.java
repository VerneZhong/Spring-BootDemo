package com.example.designpattern.combinationmode;

import java.util.Iterator;

/**
 * 空迭代器
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }


}
