package com.rafaeljaber.dynamodb.adapter.in.controller.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHistoryRequest {

    @NotEmpty
    private String username;

    @NotNull
    @PositiveOrZero
    private Double score;

}
