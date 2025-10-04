package com.api.saude.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.saude.api.entity.Sono;

@Repository
public interface SonoRepository extends JpaRepository<Sono, Long>{
    
}
