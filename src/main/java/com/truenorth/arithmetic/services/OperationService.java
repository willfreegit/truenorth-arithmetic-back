package com.truenorth.arithmetic.services;


import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;

import java.math.BigDecimal;

public interface OperationService {
    public OperationResponse mathOperations(OperationRequest operationRequest, BigDecimal balance);
}
