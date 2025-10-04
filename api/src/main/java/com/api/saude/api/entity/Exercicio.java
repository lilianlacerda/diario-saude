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
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String nome;
    @NonNull
    @Column(nullable = false)
    private Integer series;
    @NonNull
    @Column(nullable = false)
    private Integer repeticoes;
    @NonNull
    @Column(nullable = false)
    private Double carga;
    @NonNull
    @Column(nullable = false)
    private Double tempo;
    @NonNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataRegistro;
}
