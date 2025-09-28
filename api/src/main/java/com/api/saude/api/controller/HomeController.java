package com.api.saude.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/" })
    public String homePage() {
        return "index";
    }

    @GetMapping("/sono")
    public String sonoPage() {
        return "sono/sono";
    }

    @GetMapping("/exercicio")
    public String exercicioPage() {
        return "exercicio/exercicio";
    }

    @GetMapping("/refeicao")
    public String refeicaoPage() {
        return "refeicao/refeicao";
    }
}
