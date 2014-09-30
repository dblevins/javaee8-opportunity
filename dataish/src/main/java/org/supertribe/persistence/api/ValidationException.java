package org.supertribe.persistence.api;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}