package it.credem.macina_be.model.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseApplicationException {

    public BadRequestException(String message) {
        super(message, "BAD_REQUEST", HttpStatus.BAD_REQUEST);
    }
}
