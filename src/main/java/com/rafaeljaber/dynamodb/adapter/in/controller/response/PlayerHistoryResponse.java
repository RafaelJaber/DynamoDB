package com.rafaeljaber.dynamodb.adapter.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerHistoryResponse {

    private String username;
    private UUID gameId;
    private Double score;
    private Instant createdAt;

}
