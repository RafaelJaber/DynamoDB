package com.rafaeljaber.dynamodb.application.ports.out;

import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;

import java.util.List;

public interface FindAllPlayerHistoryByUsernameOutputPort {

    List<PlayerHistory> find(String username);

}
