package it.credem.macina_be.model.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseApplicationException {

    public ConflictException(String message) {
        super(message, "CONFLICT", HttpStatus.CONFLICT);
    }
}
