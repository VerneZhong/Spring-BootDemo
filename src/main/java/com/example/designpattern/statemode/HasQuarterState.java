package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;
import com.example.designpattern.common.Symbol;

import java.util.Random;

/**
 * 已支付类
 *
 * @author zhong
 */
public class HasQuarterState implements State {

    private NewGumballMachine machine;
    private Random random = new Random(System.currentTimeMillis());

    public HasQuarterState(NewGumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void ejectQuarter() {
        System.out.println(Constants.REFUND);
        machine.setState(machine.getNotQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println(Constants.ROTATING_CRANK + Symbol.COMMA + Constants.SOLD);
        int winner = random.nextInt(10);
        if ((winner == 0) && (machine.getCount() > 1)) {
            // 赢了
            machine.setState(machine.getWinnerState());
        } else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public String toString() {
        return Constants.HAS_QUARTER;
    }
}
