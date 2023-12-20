package com.example.trabalho_2_backend.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.trabalho_2_backend.model.ModeloErro;
import com.example.trabalho_2_backend.model.exceptions.ResourceBadRequestException;
import com.example.trabalho_2_backend.model.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ModeloErro erro = new ModeloErro("Not Found", ex.getMessage(), 404);
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex){
        ModeloErro erro = new ModeloErro("Bad Request", ex.getMessage(), 400);
        return ResponseEntity.status(400).body(erro);
    } 
}
