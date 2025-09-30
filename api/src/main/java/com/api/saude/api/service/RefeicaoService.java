package com.api.saude.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.saude.api.entity.Refeicao;
import com.api.saude.api.repository.RefeicaoRepository;

@Service
public class RefeicaoService {
    private final RefeicaoRepository refeicaoRepository;

    public RefeicaoService (RefeicaoRepository refeicaoRepository){
        this.refeicaoRepository = refeicaoRepository;
    }

    public List<Refeicao> listarRefeicao(){
        return refeicaoRepository.findAll();
    }

    public List<Refeicao> cadastrarRefeicao(Refeicao refeicao){
        refeicaoRepository.save(refeicao);
        return listarRefeicao();
    }

    public Refeicao buscarRefeicaoPorId(Long id){
        return refeicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refeição não encontrada pelo ID " + id));
    }

    public Refeicao editarRefeicao(Long id, Refeicao refeicaoAtualizada){

        Refeicao refeicao = buscarRefeicaoPorId(id);

        refeicao.setNome(refeicaoAtualizada.getNome());
        refeicao.setTipo(refeicaoAtualizada.getTipo());
        refeicao.setQuantidade(refeicaoAtualizada.getQuantidade());
        refeicao.setDataRegistro(refeicaoAtualizada.getDataRegistro());
        
        return refeicaoRepository.save(refeicao);
    }

    public String deletarRefeicao (Long id){
        if(!refeicaoRepository.existsById(id)){
            return "Não foi possível localizar a refeição";
        }

        refeicaoRepository.deleteById(id);
        return "Refeição excluida com sucesso" + listarRefeicao();
    }
}
