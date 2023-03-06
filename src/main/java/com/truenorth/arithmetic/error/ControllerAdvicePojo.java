package com.truenorth.arithmetic.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Centralize rest exceptions pojo
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class ControllerAdvicePojo {
    private String errorMessage;
    private String requestedURI;
}
