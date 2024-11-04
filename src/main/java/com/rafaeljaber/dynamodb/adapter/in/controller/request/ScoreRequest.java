package com.rafaeljaber.dynamodb.adapter.in.controller.request;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreRequest {

    @PositiveOrZero
    Double score;

}
