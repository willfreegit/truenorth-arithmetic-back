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
    @NotBlank
    private Double number1;
    @NotNull
    @NotBlank
    private Double number2;
    @NotNull
    @NotBlank
    private Integer stringSize;
    @NotNull
    @NotBlank
    private Long id_operation;
    @NotNull
    @NotBlank
    private String type;
}
