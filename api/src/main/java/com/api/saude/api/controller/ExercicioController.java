package com.api.saude.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.saude.api.entity.Exercicio;
import com.api.saude.api.service.ExercicioService;

@Controller
@RequestMapping("/exercicio")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController (ExercicioService exercicioService){
        this.exercicioService = exercicioService;
    }

    @GetMapping("/listar")
    public String listarEcercicios(Model model){
        model.addAttribute("exercicios", exercicioService.listarExercicios());
        return "exercicio/exercicio";
    }

    @GetMapping("/cadastrar")
    public String mostrarCadastro(Model model){
        model.addAttribute("exercicio", new Exercicio());
        return "exercicio/cadastrar";

    }

    @PostMapping("/cadastrar")
    public String cadastrarExercicio(@ModelAttribute Exercicio exercicio){
        exercicioService.criarExercicio(exercicio);
        return "redirect:/exercicio/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEdicao(@PathVariable Long id, Model model){
        Exercicio exercicio = exercicioService.buscarExercicioPorId(id);
        model.addAttribute("exercicio", exercicio);
        return "exercicio/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarExercicio(@PathVariable Long id, @ModelAttribute Exercicio exercicioAtualizado){
        exercicioService.editarExercicio(id, exercicioAtualizado);
        return "redirect:/exercicio/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarExercicio(@PathVariable Long id){
        exercicioService.excluirExercicio(id);
        return "redirect:/exercicio/listar";
    }
    
}
