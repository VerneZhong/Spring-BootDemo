package com.example.demo.util;

import com.example.demo.util.idworker.DayPrefixRandomCodeStrategy;
import com.example.demo.util.idworker.RandomCodeStrategy;
import com.example.demo.util.idworker.util.Id;

public class DayCode {
    static RandomCodeStrategy strategy;

    static {
        DayPrefixRandomCodeStrategy dayPrefixCodeStrategy = new DayPrefixRandomCodeStrategy("yyMM");
        dayPrefixCodeStrategy.setMinRandomSize(7);
        dayPrefixCodeStrategy.setMaxRandomSize(7);
        strategy = dayPrefixCodeStrategy;
        strategy.init();
    }

    public static synchronized String next() {
        return String.format("%d-%04d-%07d", Id.getWorkerId(), strategy.prefix(), strategy.next());
    }
}
