package com.rafaeljaber.dynamodb.application.core.usecase;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.core.usecase.exceptions.GameIdNotFoundException;
import com.rafaeljaber.dynamodb.application.ports.in.FindPlayerHistoryByGameIdInputPort;
import com.rafaeljaber.dynamodb.application.ports.out.FindPlayerHistoryByGameIdAndUsernameOutputPort;

import java.util.UUID;

public class FindPlayerHistoryByGameIdUseCase implements FindPlayerHistoryByGameIdInputPort {

    private final FindPlayerHistoryByGameIdAndUsernameOutputPort findPlayerHistoryByGameIdAndUsernameOutputPort;

    public FindPlayerHistoryByGameIdUseCase(
            FindPlayerHistoryByGameIdAndUsernameOutputPort findPlayerHistoryByGameIdAndUsernameOutputPort
    ) {
        this.findPlayerHistoryByGameIdAndUsernameOutputPort = findPlayerHistoryByGameIdAndUsernameOutputPort;
    }


    @Override
    public PlayerHistory find(String username, UUID gameId) {
        return findPlayerHistoryByGameIdAndUsernameOutputPort.find(username, gameId).orElseThrow(
                () -> new GameIdNotFoundException("Game id not found")
        );
    }
}
