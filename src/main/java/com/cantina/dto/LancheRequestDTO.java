package com.cantina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Builder
public record LancheRequestDTO(
        @NotBlank(message = "Campo nome não pode está vazio.")
        @Length(min = 3, max = 100)
        String nome,
        @NotBlank(message = "Campo descricao não pode está vazio.")
        @Length(max = 250)
        String descricao,
        @NotNull(message = "Campo preco não pode está vazio")
        BigDecimal preco
) {}
