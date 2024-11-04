package com.rafaeljaber.dynamodb.application.core.usecase;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.FindPlayerHistoryByGameIdInputPort;
import com.rafaeljaber.dynamodb.application.ports.in.UpdatePlayerHistoryByGameIdAndUsernameInputPort;
import com.rafaeljaber.dynamodb.application.ports.out.UpdatePlayerHistoryOutputPort;

import java.util.UUID;

public class UpdatePlayerHistoryByGameIdAndUsernameUseCase implements UpdatePlayerHistoryByGameIdAndUsernameInputPort {

    private final FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort;
    private final UpdatePlayerHistoryOutputPort updatePlayerHistoryOutputPort;

    public UpdatePlayerHistoryByGameIdAndUsernameUseCase(
            FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort,
            UpdatePlayerHistoryOutputPort updatePlayerHistoryOutputPort
    ) {
        this.findPlayerHistoryByGameIdInputPort = findPlayerHistoryByGameIdInputPort;
        this.updatePlayerHistoryOutputPort = updatePlayerHistoryOutputPort;
    }

    @Override
    public void update(String username, UUID gameId, Double score) {
        PlayerHistory playerHistory = findPlayerHistoryByGameIdInputPort.find(username, gameId);
        playerHistory.setScore(score);
        updatePlayerHistoryOutputPort.update(playerHistory);
    }
}
