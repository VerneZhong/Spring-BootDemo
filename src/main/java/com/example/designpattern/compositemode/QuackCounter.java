package com.example.designpattern.compositemode;

/**
 * 鸭子装饰器
 */
public class QuackCounter implements Quackable {

    private Quackable duck;
    private static int count;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        count++;
    }

    /**
     * 鸭子叫的次数
     * @return
     */
    public static int getCount() {
        return count;
    }
}
