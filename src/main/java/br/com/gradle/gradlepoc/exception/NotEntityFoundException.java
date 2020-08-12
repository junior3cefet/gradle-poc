package br.com.gradle.gradlepoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotEntityFoundException extends RuntimeException {

    private static final String MESSAGE = "Not found %s with id %s";

    public NotEntityFoundException(Class entity, String id) {
        super(String.format(MESSAGE, entity.getName(), id));
    }
}
