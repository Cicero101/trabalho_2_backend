package com.example.trabalho_2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalho_2_backend.model.Produto;
import com.example.trabalho_2_backend.model.exceptions.ResourceNotFoundException;
import com.example.trabalho_2_backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto adicionar(Produto produto){
        
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){

        return produtoRepository.findAll();        
    }

    public Produto obterPorId(Long id){

        Optional<Produto> optProduto = produtoRepository.findById(id);
        if (optProduto.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um produto com o Id " + id);
        }else{
            return optProduto.get();
        }
    }

    public Produto atualizar(Long id, Produto produto){

        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }

}