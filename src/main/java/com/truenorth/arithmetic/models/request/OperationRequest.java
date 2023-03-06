package com.truenorth.arithmetic.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {
    @NotNull
    private Double number1;
    @NotNull
    private Double number2;
    @NotNull
    private Integer stringSize;
    @NotNull
    private Long id_operation;
    @NotNull
    @NotBlank
    private String type;
    @NotNull
    private Long userId;
}
