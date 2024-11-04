package com.rafaeljaber.dynamodb.application.ports.in;

import java.util.UUID;

public interface DeletePlayerHistoryByGameIdAndUsernameInputPort {

    void delete(String username, UUID gameId);
}
