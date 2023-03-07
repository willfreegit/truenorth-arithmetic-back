package com.truenorth.arithmetic.services;

import com.truenorth.arithmetic.models.Operation;
import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;
import com.truenorth.arithmetic.repository.ArithmeticRepository;
import com.truenorth.arithmetic.repository.OperationRepository;
import com.truenorth.arithmetic.services.imp.OperationServiceImp;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * Test operation service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class OperationServiceTest {

    @Mock
    OperationRepository operationRepository;
    @Mock
    ArithmeticRepository arithmeticRepository;
    @InjectMocks
    private OperationServiceImp service;

    @Test
    public void testMathOperationWithParametersOk() {
        Long operationId = 1L;
        BigDecimal balance = new BigDecimal(100);
        OperationRequest operationRequest = OperationRequest.builder().number1(1.0).number2(3.0).operationId(operationId).type("NUMBER").userId(1L).build();
        Operation operation = new Operation(operationId, "ADDITION", new BigDecimal(0.1));
        when(operationRepository.findById(operationId)).thenReturn(Optional.of(operation));
        OperationResponse response = service.mathOperations(operationRequest, balance);
        Assert.assertEquals(200, response.getCode());
    }

    @Test
    public void testMathOperationWithOperationUnknown() {
        Long operationId = 100L;
        BigDecimal balance = new BigDecimal(100);
        OperationRequest operationRequest = OperationRequest.builder().number1(1.0).number2(3.0).operationId(operationId).type("NUMBER").userId(1L).build();
        OperationResponse response = service.mathOperations(operationRequest, balance);
        Assert.assertEquals(400, response.getCode());
    }

}
