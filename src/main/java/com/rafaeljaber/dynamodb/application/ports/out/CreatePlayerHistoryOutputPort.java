package com.rafaeljaber.dynamodb.application.ports.out;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

public interface CreatePlayerHistoryOutputPort {

    PlayerHistory create(PlayerHistory playerHistory);

}
