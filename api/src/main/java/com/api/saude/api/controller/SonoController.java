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

import com.api.saude.api.entity.Sono;
import com.api.saude.api.service.SonoService;

@RestController
@RequestMapping("/sono")
public class SonoController {
    private final SonoService sonoService;

    public SonoController (SonoService sonoService){
        this.sonoService = sonoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Sono>> listarSono(){
        List<Sono> sonos = sonoService.listarSono();
        return ResponseEntity.ok().body(sonos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<List<Sono>> cadastrarSono(@RequestBody Sono sono){
        List<Sono> sonoNovo = sonoService.cadastrarSono(sono);
        return ResponseEntity.ok().body(sonoNovo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Sono> editarSono(@PathVariable Long id, @RequestBody Sono sono){
        sonoService.atualizarSono(id, sono);
        return ResponseEntity.ok().body(sono);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluirSono(@PathVariable Long id){
        sonoService.deletarSono(id);
        return ResponseEntity.noContent().build();
    }
    
}
