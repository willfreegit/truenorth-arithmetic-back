package com.truenorth.arithmetic.repository;

public interface OperationRepository {
    public double addition(double number1, double number2);
    public double subtraction(double number1, double number2);
    public double multiplication(double number1, double number2);
    public double division(double number1, double number2);
    public double square_root(double number);
    public String random_string(int number, int length);
}
