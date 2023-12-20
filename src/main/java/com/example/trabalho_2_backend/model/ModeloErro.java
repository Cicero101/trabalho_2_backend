package com.example.trabalho_2_backend.model;

public class ModeloErro {
    
    private String nome;
    private String mensagem;
    private int status;


    public ModeloErro(String nome, String mensagem, int status) {
        this.nome = nome;
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }




}
