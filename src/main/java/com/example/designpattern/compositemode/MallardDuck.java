package com.example.designpattern.compositemode;

/**
 * 野鸭
 */
public class MallardDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("野鸭嘎嘎叫");
    }
}
