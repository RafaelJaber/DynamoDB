package com.rafaeljaber.dynamodb.application.ports.out;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

public interface UpdatePlayerHistoryOutputPort {

    void update(PlayerHistory playerHistory);

}
