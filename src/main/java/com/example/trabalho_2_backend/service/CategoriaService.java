package com.example.trabalho_2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalho_2_backend.model.Categoria;
import com.example.trabalho_2_backend.model.exceptions.ResourceNotFoundException;
import com.example.trabalho_2_backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria adicionar(Categoria categoria){
        
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){

        return categoriaRepository.findAll();        
    }

    public Categoria obterPorId(Long id){

        Optional<Categoria> optCategoria = categoriaRepository.findById(id);
        if (optCategoria.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um categoria com o Id " + id);
        }else{
            return optCategoria.get();
        }
    }

    public Categoria atualizar(Long id, Categoria categoria){

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }

}