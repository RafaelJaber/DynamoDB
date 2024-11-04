package com.rafaeljaber.dynamodb.adapter.in.controller.response.errors;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representação da resposta de erro específico do campo")
public class FieldMessageResponse {

    @Schema(description = "Nome do campo que causou o erro", example = "username")
    private String fieldName;

    @Schema(description = "Mensagem descritiva do erro do campo", example = "O campo 'username' não pode estar vazio.")
    private String message;

}