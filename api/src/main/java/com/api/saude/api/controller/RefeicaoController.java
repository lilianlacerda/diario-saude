package com.api.saude.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.saude.api.entity.Refeicao;
import com.api.saude.api.service.RefeicaoService;

@Controller
@RequestMapping("/refeicao")
public class RefeicaoController {

    private final RefeicaoService refeicaoService;

    public RefeicaoController (RefeicaoService refeicaoService){
        this.refeicaoService = refeicaoService;
    }

    @GetMapping("/listar")
    public String listarRefeicoes(Model model){
        model.addAttribute("refeicoes", refeicaoService.listarRefeicao());
        return "refeicao/refeicao";
    }

    @GetMapping("/cadastrar")
    public String mostrarCadastro(Model model){
        model.addAttribute("refeicao", new Refeicao());
        return "refeicao/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarRefeicao(@ModelAttribute Refeicao refeicao){
        refeicaoService.cadastrarRefeicao(refeicao);
        return "redirect:/refeicao/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEdicao(@PathVariable Long id, Model model){
        Refeicao refeicao = refeicaoService.buscarRefeicaoPorId(id);
        model.addAttribute("refeicao", refeicao);
        return "refeicao/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarRefeicao (@PathVariable Long id, @ModelAttribute Refeicao refeicaoAtualizado){
        refeicaoService.editarRefeicao(id, refeicaoAtualizado);
        return "redirect:/refeicao/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarRefeicao (@PathVariable Long id){
        refeicaoService.deletarRefeicao(id);
        return "redirect:/refeicao/listar";
    }
}
