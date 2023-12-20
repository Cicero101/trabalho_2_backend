package com.example.trabalho_2_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalho_2_backend.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}