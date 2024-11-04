package com.rafaeljaber.dynamodb.application.ports.in;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

import java.util.UUID;

public interface FindPlayerHistoryByGameIdInputPort {

    PlayerHistory find(String username, UUID gameId);

}
