package br.com.cielo.bootcampdesafio02.controllers.exceptions;

import br.com.cielo.bootcampdesafio02.api.controller.exception.ControllerExceptionHandler;
import br.com.cielo.bootcampdesafio02.api.controller.exception.StandardError;
import br.com.cielo.bootcampdesafio02.api.controller.exception.ValidationError;
import br.com.cielo.bootcampdesafio02.api.service.exceptions.EntityNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerExceptionHandlerTest {

    @InjectMocks
    private ControllerExceptionHandler exceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEntityNotFound() {
        EntityNotFound entityNotFound = new EntityNotFound("Resource not found");
        MockHttpServletRequest request = new MockHttpServletRequest();
        ResponseEntity<StandardError> response = exceptionHandler.entityNotFound(entityNotFound, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found", response.getBody().getMessage());
    }

}