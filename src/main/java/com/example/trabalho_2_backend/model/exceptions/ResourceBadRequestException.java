package com.example.trabalho_2_backend.model.exceptions;

public class ResourceBadRequestException  extends RuntimeException {

    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }
    
}
