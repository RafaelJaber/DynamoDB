package com.rafaeljaber.dynamodb.application.core.usecase;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.CreatePlayerHistoryInputPort;
import com.rafaeljaber.dynamodb.application.ports.out.CreatePlayerHistoryOutputPort;

import java.time.Instant;
import java.util.UUID;

public class CreatePlayerHistoryUseCase implements CreatePlayerHistoryInputPort {

    private final CreatePlayerHistoryOutputPort createPlayerHistoryOutputPort;


    public CreatePlayerHistoryUseCase(CreatePlayerHistoryOutputPort createPlayerHistoryOutputPort) {
        this.createPlayerHistoryOutputPort = createPlayerHistoryOutputPort;
    }

    @Override
    public PlayerHistory create(PlayerHistory playerHistory) {
        playerHistory.setCreatedAt(Instant.now());
        playerHistory.setGameId(UUID.randomUUID());
        return createPlayerHistoryOutputPort.create(playerHistory);
    }
}
