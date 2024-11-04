package com.rafaeljaber.dynamodb.adapter.in.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representa uma requisição para atualizar a pontuação de um jogador")
public class ScoreRequest {

    @PositiveOrZero
    @Schema(description = "Pontuação do jogador, deve ser zero ou positivo", example = "100.5")
    Double score;

}