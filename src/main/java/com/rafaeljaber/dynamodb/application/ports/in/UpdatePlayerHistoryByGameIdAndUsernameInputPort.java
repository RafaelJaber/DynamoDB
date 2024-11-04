package com.rafaeljaber.dynamodb.application.ports.in;

import java.util.UUID;

public interface UpdatePlayerHistoryByGameIdAndUsernameInputPort {

    void update(String username, UUID gameId, Double score);

}
