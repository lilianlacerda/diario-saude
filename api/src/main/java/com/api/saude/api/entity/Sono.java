package com.api.saude.api.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private Integer horasDormidas;
    @NonNull
    @Column(nullable = false)
    private String qualidadeSono;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull
    @Column(nullable = false)
    private LocalDate dataRegistro;
    
}
