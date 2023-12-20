package com.example.trabalho_2_backend.model.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (String mensagem) {
        super(mensagem);
    }
}
