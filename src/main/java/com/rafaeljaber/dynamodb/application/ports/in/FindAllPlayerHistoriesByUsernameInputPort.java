package com.rafaeljaber.dynamodb.application.ports.in;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

import java.util.List;

public interface FindAllPlayerHistoriesByUsernameInputPort {

    List<PlayerHistory> find(String username);

}
