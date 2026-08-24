package com.cantina.service;

import com.cantina.dto.LancheListaDTO;
import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.exception.LancheNotFoundException;
import com.cantina.model.Lanche;
import com.cantina.repository.LancheRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {
    @Autowired
    private LancheRepository lancheRepository;

    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        Lanche lanche = Lanche.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .build();

        lancheRepository.save(lanche);

        return toResponse(lanche);
    };

    public List<LancheListaDTO> listar() {
        List<Lanche> lancheList = lancheRepository.findAll();

        return lancheList.stream()
                .map(lanche -> new LancheListaDTO(lanche.getNome(), lanche.getPreco()))
                .toList();
    }

    public LancheResponseDTO filtrarPorId(Long id) {
        Lanche lanche = lancheRepository.findById(id)
                .orElseThrow(() -> new LancheNotFoundException("Lanche não encontrado."));

        return toResponse(lanche);
    }

    public void deletarLanche(Long id) {
        lancheRepository.findById(id)
                .orElseThrow(() -> new LancheNotFoundException("Lanche não encontrado."));

        lancheRepository.deleteById(id);
    }

    public LancheResponseDTO atualizar(Long id, @Valid LancheRequestDTO lanche) {
        Lanche lancheExist = lancheRepository.findById(id)
                .orElseThrow(() -> new LancheNotFoundException("Lanche não encontrado."));

        lancheExist.setNome(lanche.nome());
        lancheExist.setDescricao(lanche.descricao());
        lancheExist.setPreco(lanche.preco());

        lancheRepository.save(lancheExist);

        return toResponse(lancheExist);
    }

    public LancheResponseDTO toResponse(Lanche lanche) {
        return LancheResponseDTO.builder()
                .id(lanche.getId())
                .nome(lanche.getNome())
                .descricao(lanche.getDescricao())
                .preco(lanche.getPreco())
                .build();
    }
}
