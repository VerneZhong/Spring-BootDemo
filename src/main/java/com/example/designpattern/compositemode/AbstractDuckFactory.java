package com.example.designpattern.compositemode;

/**
 * 鸭抽象工厂类
 */
public abstract class AbstractDuckFactory {

    abstract Quackable createMallardDuck();
    abstract Quackable createRedheadDuck();
    abstract Quackable createDuckCall();
    abstract Quackable createRubberDuck();

    abstract Quackable createGoose();

}
