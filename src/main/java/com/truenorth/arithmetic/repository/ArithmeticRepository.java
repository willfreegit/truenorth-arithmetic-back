package com.truenorth.arithmetic.repository;

import com.truenorth.arithmetic.functions.ArithmeticOperator;

public interface ArithmeticRepository {
    public double mathOperations(ArithmeticOperator operation, Double a, Double b);
    public String random_string(int length);
}
