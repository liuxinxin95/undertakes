package com.example.undertakes.service;

@FunctionalInterface
public interface Formula {

//    void bask(String msg);
//     计算
    double calculate(int a);

    // 求平方根
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
