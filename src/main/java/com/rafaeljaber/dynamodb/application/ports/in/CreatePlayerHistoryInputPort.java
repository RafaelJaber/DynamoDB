package com.rafaeljaber.dynamodb.application.ports.in;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

public interface CreatePlayerHistoryInputPort {

    PlayerHistory create(PlayerHistory playerHistory);

}
