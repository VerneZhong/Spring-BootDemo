package com.example.designpattern.statemode;

/**
 * 糖果机
 *
 * @author zxb
 */
public class GumballMachine {

    /**
     * 卖光了
     */
    public static final int SOLD_OUT = 0;
    /**
     * 未投币
     */
    public static final int NO_QUARTER = 1;
    /**
     * 已投币
     */
    public static final int HAS_QUARTER = 2;
    /**
     * 出售
     */
    public static final int SOLD = 3;

    /**
     * 当前状态
     */
    private int state = SOLD_OUT;
    /**
     * 库存数量
     */
    private int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (this.count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投入硬币
     */
    public void insertQuarter() {
        switch (this.state) {
            case SOLD_OUT:
                System.out.println("不能投币，糖果卖光了~");
                break;
            case NO_QUARTER:
                System.out.println("投币中~");
                state = HAS_QUARTER;
                break;
            case HAS_QUARTER:
                System.out.println("已投币，不能再投币~");
                break;
            case SOLD:
                System.out.println("请等待处理，一会再投币~");
                break;
            default:
                System.out.println("非法操作！");
                break;
        }
    }

    /**
     * 弹出硬币
     */
    public void ejectQuarter() {
        switch (this.state) {
            case SOLD_OUT:
                System.out.println("无法弹出硬币，糖果卖光了~");
                break;
            case NO_QUARTER:
                System.out.println("不能弹出硬币，未投币~");
                break;
            case HAS_QUARTER:
                System.out.println("弹出硬币~");
                state = NO_QUARTER;
                break;
            case SOLD:
                System.out.println("不能弹出硬币，发放糖果中~");
                break;
            default:
                System.out.println("非法操作！");
                break;
        }
    }

    /**
     * 转曲柄
     */
    public void turnCrank() {
        switch (this.state) {
            case SOLD_OUT:
                System.out.println("不能转曲柄，糖果卖光了~");
                break;
            case NO_QUARTER:
                System.out.println("不能转曲柄，请投币~");
                break;
            case HAS_QUARTER:
                System.out.println("转曲柄，发放糖果~");
                state = SOLD;
                dispense();
                break;
            case SOLD:
                System.out.println("请等待，正在发放糖果中~");
                break;
            default:
                System.out.println("非法操作！");
                break;
        }
    }

    /**
     * 发放糖果
     */
    private void dispense() {
        switch (this.state) {
            case SOLD_OUT:
                System.out.println("不能发放糖果，糖果卖光了~");
                break;
            case NO_QUARTER:
                System.out.println("不能发放糖果，请投币~");
                break;
            case HAS_QUARTER:
                System.out.println("不能投币，请等待糖果发放~");
                break;
            case SOLD:
                System.out.println("发放糖果中~");
                count--;
                if (count == 0) {
                    state = SOLD_OUT;
                } else {
                    state = NO_QUARTER;
                }
                break;
            default:
                System.out.println("非法操作！");
                break;
        }
    }

    public String getState() {
        switch (this.state) {
            case SOLD_OUT:
                return "售罄";
            case NO_QUARTER:
                return "未投币";
            case HAS_QUARTER:
                return "已投币";
            case SOLD:
                return "出货中";
            default:
                return "未知状态";
        }
    }

    @Override
    public String toString() {
        return "糖果机状态：" + getState() + "--- 糖果数量：" + this.count;
    }

    /**
     * 补货
     * @param count
     */
    public void refill(int count) {
        this.count = count;
        this.state = NO_QUARTER;
    }
}
