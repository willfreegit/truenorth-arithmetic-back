package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;
import com.truenorth.arithmetic.services.BalanceService;
import com.truenorth.arithmetic.services.OperationService;
import com.truenorth.arithmetic.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

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

    @Autowired
    private RecordService recordService;

    @PostMapping("/mathOperations")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OperationResponse> mathOperations(@RequestBody OperationRequest operationRequest){
        BigDecimal balance = balanceService.getBalanceByUser(operationRequest.getUserId());
        OperationResponse response = operationService.mathOperations(operationRequest, balance);
        /**
         * Only if the operation was right then update the balance database
         */
        if(200 == response.getCode()){
            if(balanceService.updateBalanceByUser(operationRequest.getUserId(), response.getCost())){
                /**
                 * If the whole operation was ok, register into record table
                 */
                response.setBalance(balance.subtract(response.getCost()));
                if(!recordService.saveRecord(Record
                        .builder()
                        .operationId(operationRequest.getOperationId())
                        .userId(operationRequest.getUserId())
                        .amount(response.getCost())
                        .userBalance(response.getBalance())
                        .operationResponse(String.valueOf(response.getCode()))
                        .dateOperation(Date.valueOf(LocalDate.now()))
                        .build())){
                    /**
                     * Pending implement notification by email to the admin...
                     */
                }
            } else{
                /**
                 * Pending implement notification by email to the admin...
                 */
            }
        }
        return ResponseEntity.ok(response);
    }

}
