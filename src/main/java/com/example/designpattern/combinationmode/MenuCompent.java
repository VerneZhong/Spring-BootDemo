package com.example.designpattern.combinationmode;

import java.util.Iterator;

/**
 * 菜单组合
 * todo 为叶节点或组合节点提供的超类
 */
public abstract class MenuCompent {

    public void add(MenuCompent menuCompent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuCompent menuCompent) {
        throw new UnsupportedOperationException();
    }

    public MenuCompent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDesc() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    /**
     * 创建迭代器
     * @return
     */
    public abstract Iterator<MenuCompent> createIterator();
}
