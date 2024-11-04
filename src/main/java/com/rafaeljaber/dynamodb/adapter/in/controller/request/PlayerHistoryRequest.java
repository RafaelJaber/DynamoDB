package com.rafaeljaber.dynamodb.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representa uma requisição para criar o histórico de um jogador")
public class PlayerHistoryRequest {

    @NotEmpty
    @Schema(description = "Username do jogador", example = "john_doe")
    private String username;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Pontuação do jogador, deve ser zero ou positivo", example = "100.5")
    private Double score;
}