package com.example.designpattern.statemode;

import lombok.Data;

/**
 * 改造的糖果机
 */
@Data
public class NewGumballMachine {

    /**
     * 卖光了
     */
    private State soldOutState;
    /**
     * 未投币
     */
    private State notQuarterState;
    /**
     * 已投币
     */
    private State hasQuarterState;
    /**
     * 出售
     */
    private State soldState;
    /**
     * 中奖状态
     */
    private State winnerState;

    /**
     * 当前状态
     */
    private State state;
    /**
     * 库存数量
     */
    private int count = 0;

    public NewGumballMachine(int count) {
        this.soldOutState = new SoldOutState(this);
        this.notQuarterState = new NotQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.state = getSoldOutState();
        this.count = count;
        if (getCount() > 0) {
            state = getNotQuarterState();
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense() {
        state.dispense();
    }

    /**
     * 释放糖果
     */
    public void releaseBall() {
        System.out.println("一个糖球从槽中滚出来~");
        if (getCount() != 0) {
            count--;
        }
    }

    @Override
    public String toString() {
        return "糖果机状态：" + getState() + "--- 糖果数量：" + getCount();
    }

    /**
     * 补货
     * @param count
     */
    public void refill(int count) {
        this.count = count;
        this.state = getNotQuarterState();
    }

}
