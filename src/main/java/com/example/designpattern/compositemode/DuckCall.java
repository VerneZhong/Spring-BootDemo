package com.example.designpattern.compositemode;

/**
 * 鸭鸣器
 */
public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("鸭鸣器嘎嘎叫");
    }
}
