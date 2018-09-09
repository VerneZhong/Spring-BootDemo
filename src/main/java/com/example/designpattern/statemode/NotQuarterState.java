package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;

/**
 * 未支付类
 *
 * @author zhong
 */
public class NotQuarterState implements State {

    private NewGumballMachine machine;

    public NotQuarterState(NewGumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println(Constants.PAYING);
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public String toString() {
        return Constants.NOT_QUARTER;
    }
}
