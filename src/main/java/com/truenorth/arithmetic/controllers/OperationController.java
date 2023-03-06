package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/random_string")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String getRandomString(@RequestParam(name = "number") int number,
                                        @RequestParam(name = "length") int length){
        return operationService.random_string(number, length);
    }

    @GetMapping("/addition")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public double addition(@RequestParam(name = "number1") double number1,
                                  @RequestParam(name = "number2") double number2){
        return operationService.addition(number1, number2);
    }

    @GetMapping("/subtraction")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public double subtraction(@RequestParam(name = "number1") double number1,
                           @RequestParam(name = "number2") double number2){
        return operationService.subtraction(number1, number2);
    }

    @GetMapping("/multiplication")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public double multiplication(@RequestParam(name = "number1") double number1,
                              @RequestParam(name = "number2") double number2){
        return operationService.multiplication(number1, number2);
    }

    @GetMapping("/division")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public double division(@RequestParam(name = "number1") double number1,
                                 @RequestParam(name = "number2") double number2){
        return operationService.division(number1, number2);
    }

    @GetMapping("/square_root")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public double square_root(@RequestParam(name = "number") double number){
        return operationService.square_root(number);
    }
}
