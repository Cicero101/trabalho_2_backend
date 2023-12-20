package com.example.trabalho_2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalho_2_backend.model.Endereco;
import com.example.trabalho_2_backend.model.exceptions.ResourceNotFoundException;
import com.example.trabalho_2_backend.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public Endereco adicionar(Endereco endereco){
        
        endereco.setId(null);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos(){

        return enderecoRepository.findAll();        
    }

    public Endereco obterPorId(Long id){

        Optional<Endereco> optEndereco = enderecoRepository.findById(id);
        if (optEndereco.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um endereco com o Id " + id);
        }else{
            return optEndereco.get();
        }
    }

    public Endereco atualizar(Long id, Endereco endereco){

        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }

}