package com.api.saude.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.saude.api.entity.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long>{
    
}
