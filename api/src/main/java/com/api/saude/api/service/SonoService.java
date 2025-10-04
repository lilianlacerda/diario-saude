package com.api.saude.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.saude.api.entity.Sono;
import com.api.saude.api.repository.SonoRepository;

@Service
public class SonoService {

    private final SonoRepository sonoRepository;

    public SonoService(SonoRepository sonoRepository) {
        this.sonoRepository = sonoRepository;
    }

    public List<Sono> listarSono() {
        return sonoRepository.findAll();
    }

    public List<Sono> cadastrarSono(Sono sono) {
        try {
            sonoRepository.save(sono);
            return listarSono();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar sono");
        }
    }

    public Sono buscarSonoPorId(Long id) {
        return sonoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sono não encontrado com o ID: " + id));
    }

    public Sono atualizarSono(Long id, Sono sonoAtualizado) {
        try {
            Sono sonoExistente = buscarSonoPorId(id);

            sonoExistente.setHorasDormidas(sonoAtualizado.getHorasDormidas());
            sonoExistente.setQualidadeSono(sonoAtualizado.getQualidadeSono());
            sonoExistente.setDataRegistro(sonoAtualizado.getDataRegistro());

            return sonoRepository.save(sonoExistente);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar sono");
        }
    }

    public String deletarSono(Long id) {
        try {
            sonoRepository.deleteById(id);
            return "Sono deletado com sucesso!";
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir sono");
        }  
    }
}
