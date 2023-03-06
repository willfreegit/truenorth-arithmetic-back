package com.truenorth.arithmetic.services;


import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;

import java.math.BigDecimal;

/**
 * Class operation service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
public interface OperationService {
    public OperationResponse mathOperations(OperationRequest operationRequest, BigDecimal balance);
}
