package com.example.demo.util.idworker.util;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
