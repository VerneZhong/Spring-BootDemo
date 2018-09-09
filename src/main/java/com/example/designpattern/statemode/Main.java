package com.example.designpattern.statemode;

public class Main {

    public static void main(String[] args) {

//        GumballMachine gumballMachine = new GumballMachine(5);
        NewGumballMachine gumballMachine = new NewGumballMachine(5);

        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        gumballMachine.dispense();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.refill(2);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        System.out.println(gumballMachine);

    }
}
