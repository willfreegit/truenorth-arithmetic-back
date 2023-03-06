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

import java.util.Optional;

@Service
public class OperationServiceImp implements OperationService {

    @Autowired
    private ArithmeticRepository arithmeticRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public OperationResponse mathOperations(OperationRequest operationRequest) {
        Optional<Operation> operation = operationRepository.findById(operationRequest.getId_operation());
        if (operation.isPresent()) {
            if ("STRING" .equalsIgnoreCase(operationRequest.getType())) {
                String result = "";
                try {
                    result = arithmeticRepository.random_string(operationRequest.getStringSize());
                    return new OperationResponse<>(200, "OK", result);
                } catch (Exception ex) {
                    return new OperationResponse<>(500, ex.getMessage(), result);
                }
            } else {
                String arithmeticExpresion = operation.get().getType();
                if (arithmeticExpresion != null) {
                    double result = 0;
                    try {
                        result = arithmeticRepository.mathOperations(ArithmeticOperator.valueOf(arithmeticExpresion), operationRequest.getNumber1(), operationRequest.getNumber2());
                        return new OperationResponse<>(200, "OK", result);
                    } catch (Exception ex) {
                        return new OperationResponse<>(500, ex.getMessage(), result);
                    }
                }
            }
        }
        return new OperationResponse<>(200, "OPERATION NOT FOUND", null);
    }

}
