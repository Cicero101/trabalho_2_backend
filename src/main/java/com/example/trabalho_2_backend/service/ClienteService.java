package com.example.trabalho_2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalho_2_backend.model.Cliente;
import com.example.trabalho_2_backend.model.exceptions.ResourceNotFoundException;
import com.example.trabalho_2_backend.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente adicionar(Cliente cliente){
        
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos(){

        return clienteRepository.findAll();        
    }

    public Cliente obterPorId(Long id){

        Optional<Cliente> optCliente = clienteRepository.findById(id);
        if (optCliente.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um cliente com o Id " + id);
        }else{
            return optCliente.get();
        }
    }

    public Cliente atualizar(Long id, Cliente cliente){

        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

}