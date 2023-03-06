package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;
import com.truenorth.arithmetic.services.BalanceService;
import com.truenorth.arithmetic.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Class operations controller
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/mathOperations")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OperationResponse> mathOperations(@RequestBody OperationRequest operationRequest){
        BigDecimal balance = balanceService.getBalanceByUser(operationRequest.getUserId());
        OperationResponse response = operationService.mathOperations(operationRequest, balance);
        /**
         * Only if the operation was right then we update the balance database
         */
        if(200 == response.getCode()){
            balanceService.updateBalanceByUser(operationRequest.getUserId(), response.getCost());
        }
        return ResponseEntity.ok(response);
    }

}
