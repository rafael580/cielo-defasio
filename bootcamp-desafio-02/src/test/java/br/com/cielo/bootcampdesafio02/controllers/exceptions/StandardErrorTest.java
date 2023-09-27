package br.com.cielo.bootcampdesafio02.controllers.exceptions;

import br.com.cielo.bootcampdesafio02.api.controller.exception.StandardError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDate;

public class StandardErrorTest {



    @Test
    public void standard_Exist(){
        StandardError standardError = new StandardError();
        Assertions.assertNotNull(standardError);
    }
    @Test
    public void get_timestamp(){
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        Assertions.assertNotNull(standardError.getTimestamp());
    }
    @Test
    public void get_status(){
        StandardError standardError = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        standardError.setStatus(status.value());
        Assertions.assertNotNull(standardError.getStatus());
    }
    @Test
    public void get_error() {
        StandardError standardError = new StandardError();
        standardError.setError("ERROR TEST");
        Assertions.assertNotNull(standardError.getError());
    }
    @Test
    public void get_message() {
        StandardError standardError = new StandardError();
        standardError.setMessage("message TEST");
        Assertions.assertNotNull(standardError.getMessage());
    }
    @Test
    public void get_path() {
        StandardError standardError = new StandardError();
        standardError.setPath("http");
        Assertions.assertNotNull(standardError.getPath());
    }

}
