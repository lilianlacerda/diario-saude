package com.api.saude.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.saude.api.entity.Exercicio;
import com.api.saude.api.service.ExercicioService;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController (ExercicioService exercicioService){
        this.exercicioService = exercicioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Exercicio>> listarEcercicios(){
        List<Exercicio> exercicios = exercicioService.listarExercicios();
        return ResponseEntity.ok().body(exercicios);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<List<Exercicio>> cadastrarExercicio(@RequestBody Exercicio exercicio){
        List<Exercicio> exercicioNovo = exercicioService.criarExercicio(exercicio);
        return ResponseEntity.ok().body(exercicioNovo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Exercicio> editarExercicio(@PathVariable Long id, @RequestBody Exercicio exercicio){
        exercicioService.editarExercicio(id, exercicio);
        return ResponseEntity.ok().body(exercicio);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable Long id){
        exercicioService.excluirExercicio(id);
        return ResponseEntity.noContent().build();
    }
    
}
