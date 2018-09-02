package com.example.demo.util.idworker;

public interface RandomCodeStrategy {

    void init();

    int prefix();

    int next();

    void release();
}
