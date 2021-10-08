package com.template.controller;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Base controller that provides exception handler.
 * Controllers that have to have exception handler logic must extend it
 */
public abstract class BaseController {

    /**
     * Handle validation error.
     *
     * @param exception Validation exc
     * @return Map where keys are invalid params and values are messages
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExc(
        final BindException exception
    ) {
        return exception.getBindingResult()
            .getAllErrors()
            .stream()
            .collect(Collectors.toMap(
                objectError -> ((FieldError) objectError).getField(),
                DefaultMessageSourceResolvable::getDefaultMessage
                )
            );
    }
}
