package com.api.saude.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.saude.api.entity.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{
    
}
