package com.pedromiranda.transportadoraapi.controller.exceptions;

import com.pedromiranda.transportadoraapi.service.exceptions.CaminhaoNotFoundException;
import com.pedromiranda.transportadoraapi.service.exceptions.MotoristaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MotoristaNotFoundException.class)
    public ResponseEntity<StandardError> motoristaNotFoundException(MotoristaNotFoundException ex, HttpServletRequest request) {
        String err = "Record do not exist";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(CaminhaoNotFoundException.class)
    public ResponseEntity<StandardError> caminhaoNotFoundException(CaminhaoNotFoundException ex, HttpServletRequest request) {
        String err = "Record do not exist";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String err = "Http message not readable exception";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        StandardError error = new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), err, request.getRequestURI());

        return ResponseEntity
                .status(status)
                .body(error);
    }
}
