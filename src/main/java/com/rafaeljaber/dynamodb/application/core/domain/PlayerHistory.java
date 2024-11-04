package com.rafaeljaber.dynamodb.application.core.domain;

import java.time.Instant;
import java.util.UUID;


public class PlayerHistory {

    private String username;
    private UUID gameId;
    private Double score;
    private Instant createdAt;


    public PlayerHistory() {
    }

    public PlayerHistory(String username, UUID gameId, Double score, Instant createdAt) {
        this.username = username;
        this.gameId = gameId;
        this.score = score;
        this.createdAt = createdAt;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
