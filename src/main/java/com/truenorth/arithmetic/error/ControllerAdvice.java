package com.truenorth.arithmetic.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Centralize rest exceptions
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ControllerAdvicePojo handleException(final Exception exception, final HttpServletRequest request) {
        return new ControllerAdvicePojo(exception.getMessage(), request.getRequestURI());
    }
}
