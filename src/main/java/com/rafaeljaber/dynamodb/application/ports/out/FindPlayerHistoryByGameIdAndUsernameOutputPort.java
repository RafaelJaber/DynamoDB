package com.rafaeljaber.dynamodb.application.ports.out;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

import java.util.Optional;
import java.util.UUID;

public interface FindPlayerHistoryByGameIdAndUsernameOutputPort {

    Optional<PlayerHistory> find(String username, UUID gameId);

}
