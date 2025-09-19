package com.api.saude.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.saude.api.entity.Exercicio;
import com.api.saude.api.repository.ExercicioRepository;

@Service
public class ExercicioService {
    
    private final ExercicioRepository exercicioRepository;

    public ExercicioService (ExercicioRepository exercicioRepository){
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> listarExercicios (){
        return exercicioRepository.findAll();
    }

    public List<Exercicio> criarExercicio(Exercicio exercicio){
        exercicioRepository.save(exercicio);
        return listarExercicios();
    }

    public Exercicio editarExercicio(Long id, Exercicio exercicioAtual){
        Exercicio exercicio = exercicioRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Não foi encontrado nenhum exercicio com esse ID" + id));
        exercicio.setNome(exercicioAtual.getNome());
        exercicio.setData(exercicioAtual.getData());
        exercicio.setSeries(exercicioAtual.getSeries());
        exercicio.setRepeticoes(exercicioAtual.getRepeticoes());
        exercicio.setCarga(exercicioAtual.getCarga());
        exercicio.setTempo(exercicioAtual.getTempo());
        
        return exercicioRepository.save(exercicio);
    }

    public String excluirExercicio(Long id){
        exercicioRepository.deleteById(id);
        return "Exercício excluido com sucesso" + listarExercicios();
    }
}