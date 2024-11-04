package com.rafaeljaber.dynamodb.application.core.usecase;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.DeletePlayerHistoryByGameIdAndUsernameInputPort;
import com.rafaeljaber.dynamodb.application.ports.in.FindPlayerHistoryByGameIdInputPort;
import com.rafaeljaber.dynamodb.application.ports.out.DeletePlayerHistoryOutputPort;

import java.util.UUID;

public class DeletePlayerHistoryByGameIdAndUsernameUseCase implements DeletePlayerHistoryByGameIdAndUsernameInputPort {

    private final FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort;
    private final DeletePlayerHistoryOutputPort deletePlayerHistoryOutputPort;

    public DeletePlayerHistoryByGameIdAndUsernameUseCase(
            FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort,
            DeletePlayerHistoryOutputPort deletePlayerHistoryOutputPort
    ) {
        this.findPlayerHistoryByGameIdInputPort = findPlayerHistoryByGameIdInputPort;
        this.deletePlayerHistoryOutputPort = deletePlayerHistoryOutputPort;
    }

    @Override
    public void delete(String username, UUID gameId) {
        PlayerHistory playerHistory = findPlayerHistoryByGameIdInputPort.find(username, gameId);
        deletePlayerHistoryOutputPort.delete(playerHistory);
    }
}
