package com.example.demo.controller;

import com.example.demo.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/asyncTask")
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/task")
    public String task() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> f1 = asyncTask.doTask11();
        Future<Boolean> f2 = asyncTask.doTask22();
        Future<Boolean> f3 = asyncTask.doTask33();

        while (!f1.isDone() || !f2.isDone() || !f3.isDone()) {
            if (f1.isDone() && f2.isDone() && f3.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String s = "任务全部完成，总耗时：" + (end - start) + "毫秒";

        System.out.println(s);
        return s;
    }
}
