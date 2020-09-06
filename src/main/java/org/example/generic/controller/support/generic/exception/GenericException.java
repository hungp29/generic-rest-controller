package org.example.generic.controller.support.generic.exception;

/**
 * Defined common Exception for Generic module.
 *
 * @author hungp
 */
public class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable thr) {
        super(message, thr);
    }
}
