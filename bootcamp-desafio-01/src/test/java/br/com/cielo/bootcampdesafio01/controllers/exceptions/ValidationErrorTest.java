package br.com.cielo.bootcampdesafio01.controllers.exceptions;

import br.com.cielo.bootcampdesafio01.api.controller.exception.ValidationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ValidationErrorTest {


    @Test
    public void validation_exist(){
        ValidationError validationError = new ValidationError();
        Assertions.assertNotNull(validationError);
    }
    @Test
    public void get_time(){
        ValidationError validationError = new ValidationError();
        validationError.setTimestamp(Instant.now());
        Assertions.assertNotNull(validationError.getTimestamp());
    }
    @Test
    public void get_status(){
        ValidationError validationError = new ValidationError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        validationError.setStatus(status.value());
        Assertions.assertNotNull(validationError.getStatus());
    }
    @Test
    public void get_error() {
        ValidationError validationError = new ValidationError();
        validationError.setError("ERROR TEST");
        Assertions.assertNotNull(validationError.getError());
    }
    @Test
    public void get_message() {
        ValidationError validationError = new ValidationError();
        validationError.setMessage("message TEST");
        Assertions.assertNotNull(validationError.getMessage());
    }
    @Test
    public void get_path() {
        ValidationError validationError = new ValidationError();
        validationError.setPath("http");
        Assertions.assertNotNull(validationError.getPath());
    }

}
