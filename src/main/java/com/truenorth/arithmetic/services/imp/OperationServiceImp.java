package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.functions.ArithmeticOperator;
import com.truenorth.arithmetic.models.Operation;
import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;
import com.truenorth.arithmetic.repository.ArithmeticRepository;
import com.truenorth.arithmetic.repository.OperationRepository;
import com.truenorth.arithmetic.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Implement operation service, business main
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Service
public class OperationServiceImp implements OperationService {

    @Autowired
    private ArithmeticRepository arithmeticRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public OperationResponse mathOperations(OperationRequest operationRequest, BigDecimal balance) {
        Optional<Operation> operationOptional = operationRepository.findById(operationRequest.getOperationId());
        if (operationOptional.isPresent()) {
            Operation operation = operationOptional.get();
            if(balance.compareTo(operation.getCost()) < 0){
                return OperationResponse
                        .builder()
                        .code(403)
                        .message("BALANCE NOT ENOUGH")
                        .build();
            }
            if ("STRING".equalsIgnoreCase(operationRequest.getType())) {
                try {
                    String result = arithmeticRepository.random_string(operationRequest.getStringSize());
                    return OperationResponse
                            .builder()
                            .code(200)
                            .data(result)
                            .cost(operation.getCost())
                            .build();
                } catch (Exception ex) {
                    return OperationResponse
                            .builder()
                            .code(500)
                            .message(ex.getMessage())
                            .build();
                }
            } else {
                String arithmeticExpresion = operation.getType();
                if (arithmeticExpresion != null) {
                    try {
                        double result = arithmeticRepository.mathOperations(ArithmeticOperator.valueOf(arithmeticExpresion), operationRequest.getNumber1(), operationRequest.getNumber2());
                        return OperationResponse
                                .builder()
                                .code(200)
                                .data(result)
                                .cost(operation.getCost())
                                .build();
                    } catch (Exception ex) {
                        return OperationResponse
                                .builder()
                                .code(500)
                                .message(ex.getMessage())
                                .build();
                    }
                }
            }
        }
        return OperationResponse
                .builder()
                .code(400)
                .message("OPERATION NOT FOUND")
                .build();
    }

}
