package org.example.generic.controller.support.generic.exception;

/**
 * Exception for configuration invalid.
 *
 * @author hungp
 */
public class ConfigurationInvalidException extends GenericException {

    public ConfigurationInvalidException(String message) {
        super(message);
    }

    public ConfigurationInvalidException(String message, Throwable thr) {
        super(message, thr);
    }
}
