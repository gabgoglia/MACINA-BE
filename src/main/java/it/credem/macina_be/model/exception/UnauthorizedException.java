package it.credem.macina_be.model.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BaseApplicationException {

    public UnauthorizedException(String message) {
        super(message, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
}
