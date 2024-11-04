package com.rafaeljaber.dynamodb.adapter.in.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação da resposta da API para o histórico de um jogador")
public class PlayerHistoryResponse {

    @Schema(description = "Username do jogador", example = "johndoe")
    private String username;

    @Schema(description = "ID do jogo", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID gameId;

    @Schema(description = "Pontuação do jogador", example = "100.5")
    private Double score;

    @Schema(description = "Data e hora em que o registro foi criado", example = "2023-01-01T00:00:00Z")
    private Instant createdAt;

}