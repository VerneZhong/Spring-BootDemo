package com.example.designpattern.compositemode;

public class GooseFactory extends AbstractDuckFactory {

    @Override
    Quackable createMallardDuck() {
        return null;
    }

    @Override
    Quackable createRedheadDuck() {
        return null;
    }

    @Override
    Quackable createDuckCall() {
        return null;
    }

    @Override
    Quackable createRubberDuck() {
        return null;
    }

    @Override
    Quackable createGoose() {
        return new GooseAdapter(new Goose());
    }
}
