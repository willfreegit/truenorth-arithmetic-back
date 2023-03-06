package com.truenorth.arithmetic.models.response;

import java.math.BigDecimal;

/**
 * Class response operation pattern builder
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
public class OperationResponse <T> {
    private T data;
    private int code;
    private String message;
    private BigDecimal cost;

    private static <T> Integer $default$code() {
        return 200;
    }

    public static <T> OperationResponseBuilder<T> builder() {
        return new OperationResponseBuilder();
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrors(BigDecimal cost) {
        this.cost = cost;
    }

    public void setData(T data) {
        this.data = data;
    }


    public OperationResponse(Integer code, String message, BigDecimal cost, T data) {
        this.code = code;
        this.message = message;
        this.cost = cost;
        this.data = data;
    }

    public OperationResponse() {
        this.code = $default$code();
    }

    public static class OperationResponseBuilder<T> {
        private boolean code$set;
        private Integer code$value;
        private String message;
        private BigDecimal cost;
        private T data;

        OperationResponseBuilder() {
        }

        public OperationResponseBuilder<T> code(Integer code) {
            this.code$value = code;
            this.code$set = true;
            return this;
        }

        public OperationResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public OperationResponseBuilder<T> cost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public OperationResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public OperationResponse<T> build() {
            Integer code$value = this.code$value;
            if (!this.code$set) {
                code$value = OperationResponse.$default$code();
            }

            return new OperationResponse(code$value, this.message, this.cost, this.data);
        }

    }
}
