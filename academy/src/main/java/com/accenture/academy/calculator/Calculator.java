package com.accenture.academy.calculator;

public class Calculator {
    public Integer add(int x, int y) {
        if ((x >= 0 && x <= 100) || (y >= 0 && y <= 100)) {
            return x + y;
        } else throw new IllegalArgumentException("x and y should be between 0 and 100");
    }

    public Integer subtract(int x, int y) {
        if ((x >= 0 && x <= 100) || (y >= 0 && y <= 100)) {
            return x - y;
        } else throw new IllegalArgumentException("x and y should be between 0 and 100");
    }

    public Integer divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        }
        if ((x >= 0 && x <= 1000) || (y >= 1 && y <= 100)){
            return x / y;
        }else throw new IllegalArgumentException("x should be between 0 and 1000 and y should be between 1 and 100");

    }

    public Integer multiply(int x, int y) {
        if (y == 0 || x == 0) {
            throw new IllegalArgumentException("x and y can't be zero");
        }
        if ((x >= 1 && x <= 30) || (y >= 1 && y <= 30)) {
            return x * y;
        } else throw new IllegalArgumentException("x and y should be between 1 and 30");

    }
}
