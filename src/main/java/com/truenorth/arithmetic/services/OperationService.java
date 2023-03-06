package com.truenorth.arithmetic.services;


import reactor.core.publisher.Mono;

public interface OperationService {
    public double addition(double number1, double number2);
    public double subtraction(double number1, double number2);
    public double multiplication(double number1, double number2);
    public double division(double number1, double number2);
    public double square_root(double number);
    public String random_string(int number, int length);
}
