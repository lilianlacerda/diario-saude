package com.api.saude.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.saude.api.entity.Exercicio;
import com.api.saude.api.repository.ExercicioRepository;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<Exercicio> listarExercicios() {
        return exercicioRepository.findAll();
    }

    public List<Exercicio> criarExercicio(Exercicio exercicio) {
        try {
            exercicioRepository.save(exercicio);
            return listarExercicios();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar Exercício: ", e);
        }
    }

    public Exercicio buscarExercicioPorId(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado nenhum exercicio com esse ID" + id));
    }

    public Exercicio editarExercicio(Long id, Exercicio exercicioAtual) {
        try {

            Exercicio exercicioExistente = buscarExercicioPorId(id);

            exercicioExistente.setNome(exercicioAtual.getNome());
            exercicioExistente.setDataRegistro(exercicioAtual.getDataRegistro());
            exercicioExistente.setSeries(exercicioAtual.getSeries());
            exercicioExistente.setRepeticoes(exercicioAtual.getRepeticoes());
            exercicioExistente.setCarga(exercicioAtual.getCarga());
            exercicioExistente.setTempo(exercicioAtual.getTempo());

            return exercicioRepository.save(exercicioExistente);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o Exercício", e);
        }

    }

    public String excluirExercicio(Long id) {
        try {
            exercicioRepository.deleteById(id);
            return "Exercício excluido com sucesso!";
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao Excluir Exercício");
        }
    }
}