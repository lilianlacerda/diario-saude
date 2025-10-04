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
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String descricao;
    @NonNull
    @Column(nullable = false)
    private String tipo;
    @NonNull
    @Column(nullable = false)
    private Double calorias;
    @NonNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataRegistro;

}
