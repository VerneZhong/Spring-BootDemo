package com.example.designpattern.compositemode;

/**
 * 红头鸭
 */
public class RedheadDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("红头鸭嘎嘎叫");
    }
}
