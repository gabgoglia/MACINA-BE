package it.credem.macina_be.model.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseApplicationException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus httpStatus;

    protected BaseApplicationException(String message, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
