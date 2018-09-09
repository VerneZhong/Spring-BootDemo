package com.example.designpattern.statemode;

import com.example.designpattern.common.Constants;
import com.example.designpattern.common.Symbol;

public interface State {

    /**
     * 投币
     */
    default void insertQuarter() {
        System.out.println(Constants.UNABLE_PAY + Symbol.COMMA + Constants.ILLEGAL_OPERATION);
    }

    /**
     * 退币
     */
    default void ejectQuarter() {
        System.out.println(Constants.NO_REFUND + Symbol.COMMA + Constants.ILLEGAL_OPERATION);
    }

    /**
     * 摇杆
     */
    default void turnCrank() {
        System.out.println(Constants.NOT_ROTATING_CRANK + Symbol.COMMA + Constants.ILLEGAL_OPERATION);
    }

    /**
     * 出货
     */
    default void dispense() {
        System.out.println(Constants.NOT_SHIPMENT + Symbol.COMMA + Constants.ILLEGAL_OPERATION);
    }

}
