package com.truenorth.arithmetic.functions;

import java.util.function.BiFunction;

public enum ArithmeticOperator implements BiFunction<Double, Double, Double> {
    ADDITION("ADDITION", (a, b) -> a + b),
    SUBTRACTION("SUBTRACTION", (a, b) -> a - b),
    MULTIPLICATION("MULTIPLICATION", (a, b) -> a * b),
    DIVISION("DIVISION", (a, b) -> a / b),
    SQUARE_ROOT("SQUARE_ROOT", (a, b) -> Math.sqrt(a));

    private final String symbol;
    private final BiFunction<Double, Double, Double> operation;

    ArithmeticOperator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Double apply (Double a, Double b) {
        return operation.apply(a, b);
    }

    public String toString() {
        return symbol;
    }
}
