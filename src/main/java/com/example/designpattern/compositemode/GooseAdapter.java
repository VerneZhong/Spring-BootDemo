package com.example.designpattern.compositemode;

/**
 * 鹅适配器，可以适配鸭子
 */
public class GooseAdapter implements Quackable {

    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
