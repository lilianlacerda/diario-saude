package com.api.saude.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.saude.api.entity.Refeicao;
import com.api.saude.api.repository.RefeicaoRepository;

@Service
public class RefeicaoService {
    private final RefeicaoRepository refeicaoRepository;

    public RefeicaoService(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    public List<Refeicao> listarRefeicao() {
        return refeicaoRepository.findAll();
    }

    public List<Refeicao> cadastrarRefeicao(Refeicao refeicao) {
        try {
            refeicaoRepository.save(refeicao);
            return listarRefeicao();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar Refeição");
        }
    }

    public Refeicao buscarRefeicaoPorId(Long id) {
        return refeicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refeição não encontrada pelo ID " + id));
    }

    public Refeicao editarRefeicao(Long id, Refeicao refeicaoAtualizada) {
        try {
            Refeicao refeicao = buscarRefeicaoPorId(id);

            refeicao.setDescricao(refeicaoAtualizada.getDescricao());
            refeicao.setTipo(refeicaoAtualizada.getTipo());
            refeicao.setCalorias(refeicaoAtualizada.getCalorias());
            refeicao.setDataRegistro(refeicaoAtualizada.getDataRegistro());

            return refeicaoRepository.save(refeicao);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar Refeição");
        }
    }

    public String deletarRefeicao(Long id) {
        try {
            refeicaoRepository.deleteById(id);
            return "Refeição excluida com sucesso";
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar Refeição");
        }
    }
}
