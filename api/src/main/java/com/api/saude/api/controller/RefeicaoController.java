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

import com.api.saude.api.entity.Refeicao;
import com.api.saude.api.service.RefeicaoService;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {

    private final RefeicaoService refeicaoService;

    public RefeicaoController (RefeicaoService refeicaoService){
        this.refeicaoService = refeicaoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Refeicao>> listarRefeicoes(){
        List<Refeicao> refeicoes = refeicaoService.listarRefeicao();
        return ResponseEntity.ok().body(refeicoes);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<List<Refeicao>> cadastrarRefeicao(@RequestBody Refeicao refeicao){
        List<Refeicao> refeicaoNova = refeicaoService.cadastrarRefeicao(refeicao);
        return ResponseEntity.ok().body(refeicaoNova);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Refeicao> editarRefeicao (@PathVariable Long id, @RequestBody Refeicao refeicao){
        refeicaoService.editarRefeicao(id, refeicao);
        return ResponseEntity.ok().body(refeicao);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarRefeicao (@PathVariable Long id){
        refeicaoService.deletarRefeicao(id);
        return ResponseEntity.noContent().build();
    }
}
