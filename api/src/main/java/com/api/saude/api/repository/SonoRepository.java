package com.api.saude.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.saude.api.entity.Sono;

public interface SonoRepository extends JpaRepository<Sono, Long>{
    
}
