package com.cantina.dto;


import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record LancheResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco
) {}
