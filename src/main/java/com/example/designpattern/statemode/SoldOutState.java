package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;
import com.example.designpattern.common.Symbol;

/**
 * 售罄
 *
 * @author zxb
 */
public class SoldOutState implements State {

    private NewGumballMachine machine;

    public SoldOutState(NewGumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return Constants.SOLD_OUT;
    }
}
