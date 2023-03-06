package com.truenorth.arithmetic.models.response;

import com.truenorth.arithmetic.security.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse <T> {
    private int code;
    private String message;
    private T data;

    private static <T> Integer $default$code() {
        return 200;
    }

}
