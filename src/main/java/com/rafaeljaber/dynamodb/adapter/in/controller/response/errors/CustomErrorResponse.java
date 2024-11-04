package com.rafaeljaber.dynamodb.adapter.in.controller.response.errors;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação da resposta de erro customizada da API")
public class CustomErrorResponse {

    @Schema(description = "Data e hora em que o erro ocorreu", example = "2023-01-01T00:00:00Z")
    private OffsetDateTime timestamp;

    @Schema(description = "Código de status HTTP", example = "404")
    private Integer httpStatus;

    @Schema(description = "Erro HTTP", example = "Not Found")
    private String httpError;

    @Schema(description = "Descrição do erro", example = "Recurso não encontrado")
    private String error;

    @Schema(description = "Caminho da solicitação que gerou o erro", example = "/api/v1/resource")
    private String path;
}