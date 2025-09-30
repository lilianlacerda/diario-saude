package com.api.saude.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.saude.api.entity.Sono;
import com.api.saude.api.service.SonoService;

@Controller
@RequestMapping("/sono")
public class SonoController {
    private final SonoService sonoService;

    public SonoController (SonoService sonoService){
        this.sonoService = sonoService;
    }

    @GetMapping("/listar")
    public String listarSono(Model model){
        model.addAttribute("sonos", sonoService.listarSono());
        model.addAttribute("sono", new Sono());
        return "sono/sono";
    }

    @GetMapping("/cadastrar")
    public String mostrarCadastro(){
        return "sono/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarSono(@ModelAttribute Sono sono){
        sonoService.cadastrarSono(sono);
        return "redirect:/sono/listar";
    }

    //Como quero usar HTML puro por enquanto. Não usarei Put e Delete nas requisições. 
    @GetMapping("/editar/{id}")
    public String editarSono(@PathVariable Long id, Model model){
        Sono sono = sonoService.buscarSonoPorId(id);
        model.addAttribute("sono", sono);
        return "sono/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarSono(@PathVariable Long id, @ModelAttribute Sono sonoAtualizado){
        sonoService.atualizarSono(id, sonoAtualizado);
        return "redirect:/sono/listar";
    }

    @GetMapping("/deletar/{id}")
    public String excluirSono(@PathVariable Long id){
        sonoService.deletarSono(id);
        return "redirect:/sono/listar";
    }
    
}
