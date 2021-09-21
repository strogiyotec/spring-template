package com.template.exc;

/**
 * Not found exc.
 */
public final class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }
}
