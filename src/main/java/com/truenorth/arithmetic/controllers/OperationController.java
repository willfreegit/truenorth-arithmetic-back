package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.models.response.OperationResponse;
import com.truenorth.arithmetic.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/mathOperations")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OperationResponse> mathOperations(@RequestBody OperationRequest operationRequest){
        OperationResponse response = operationService.mathOperations(operationRequest);
        return ResponseEntity.ok(response);
    }

}
