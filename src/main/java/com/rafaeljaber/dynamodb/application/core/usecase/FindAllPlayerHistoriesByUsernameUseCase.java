package com.rafaeljaber.dynamodb.application.core.usecase;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.FindAllPlayerHistoriesByUsernameInputPort;
import com.rafaeljaber.dynamodb.application.ports.out.FindAllPlayerHistoryByUsernameOutputPort;

import java.util.List;

public class FindAllPlayerHistoriesByUsernameUseCase implements FindAllPlayerHistoriesByUsernameInputPort {

    private final FindAllPlayerHistoryByUsernameOutputPort findAllPlayerHistoryByUsernameOutputPort;

    public FindAllPlayerHistoriesByUsernameUseCase(
            FindAllPlayerHistoryByUsernameOutputPort findAllPlayerHistoryByUsernameOutputPort
    ) {
        this.findAllPlayerHistoryByUsernameOutputPort = findAllPlayerHistoryByUsernameOutputPort;
    }

    @Override
    public List<PlayerHistory> find(String username) {
        return findAllPlayerHistoryByUsernameOutputPort.find(username);
    }
}
