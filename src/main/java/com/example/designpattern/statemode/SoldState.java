package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;
import com.example.designpattern.common.Symbol;

/**
 * 出售类
 * @author zhong
 */
public class SoldState implements State {

    private NewGumballMachine machine;

    public SoldState(NewGumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void dispense() {
        // 扣库存
        machine.releaseBall();
        if (machine.getCount() > 0) {
            System.out.println(Constants.SHIPMENT);
            machine.setState(machine.getNotQuarterState());
        } else {
            System.out.println(Constants.SOLD_OUT);
            machine.setState(machine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return Constants.SHIPMENT;
    }
}
