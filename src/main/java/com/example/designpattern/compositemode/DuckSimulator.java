package com.example.designpattern.compositemode;

/**
 * 鸭模拟器
 */
public class DuckSimulator {

    public static void main(String[] args) {

        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        duckSimulator.simulator(duckFactory);

    }

    /**
     * 适配器、装饰者、抽象工厂、工厂、组合、迭代器、观察者
     * @param duckFactory
     */
    private void simulator(AbstractDuckFactory duckFactory) {

        DuckFlock flock = new DuckFlock();

        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = duckFactory.createGoose();

        flock.add(redheadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(goose);

        DuckFlock flockOfMallards = new DuckFlock();

        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardDuck1);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);

        System.out.println("--------鸭子模拟器--------");

//        simulator(mallardDuck);
//        simulator(redheadDuck);
//        simulator(duckCall);
//        simulator(rubberDuck);
//        simulator(goose);
        simulator(flock);
        simulator(flockOfMallards);

        System.out.println("鸭子叫的次数：" + QuackCounter.getCount());
    }

    private void simulator(Quackable quackable) {
        quackable.quack();
    }


}
