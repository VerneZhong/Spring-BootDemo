package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;
import com.example.designpattern.common.Symbol;

/**
 * win
 *
 * @author zhong
 */
public class WinnerState implements State {

    private NewGumballMachine machine;

    public WinnerState(NewGumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void dispense() {
        System.out.println("你是赢家！ 你得到两个糖果~");
        machine.releaseBall();
        if (machine.getCount() == 0) {
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            if (machine.getCount() > 0) {
                System.out.println("哎呀，用口香糖球");
                machine.setState(machine.getNotQuarterState());
            } else {
                machine.setState(machine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return Constants.WINNING;
    }
}
