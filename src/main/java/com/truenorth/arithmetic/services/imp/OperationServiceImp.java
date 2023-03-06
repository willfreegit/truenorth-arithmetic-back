package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.repository.OperationRepository;
import com.truenorth.arithmetic.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OperationServiceImp implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public double addition(double number1, double number2) {
        return operationRepository.addition(number1, number2);
    }

    @Override
    public double subtraction(double number1, double number2) {
        return operationRepository.subtraction(number1, number2);
    }

    @Override
    public double multiplication(double number1, double number2) {
        return operationRepository.multiplication(number1, number2);
    }

    @Override
    public double division(double number1, double number2) {
        return operationRepository.division(number1, number2);
    }

    @Override
    public double square_root(double number) {
        return operationRepository.square_root(number);
    }

    @Override
    public String random_string(int number, int length) {
        return operationRepository.random_string(number, length);
    }
}
