package com.truenorth.arithmetic.models.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Class response operation pattern builder
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@Builder
public class OperationResponse <T> {
    private T data;
    private int code;
    private String message;
    private BigDecimal cost;
    private BigDecimal balance;
}
