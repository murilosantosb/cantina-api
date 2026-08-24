package com.cantina.dto;

import java.math.BigDecimal;

public record LancheListaDTO(
        String nome,
        BigDecimal preco
) {}
