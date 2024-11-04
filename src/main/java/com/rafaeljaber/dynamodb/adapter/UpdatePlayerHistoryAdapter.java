package com.rafaeljaber.dynamodb.adapter;

import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.adapter.out.repository.mapper.PlayerHistoryEntityMapper;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.out.UpdatePlayerHistoryOutputPort;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdatePlayerHistoryAdapter implements UpdatePlayerHistoryOutputPort {

    private final DynamoDbTemplate dynamoDbTemplate;
    private final PlayerHistoryEntityMapper playerHistoryEntityMapper;

    @Override
    public void update(PlayerHistory playerHistory) {
        PlayerHistoryEntity playerHistoryEntity = playerHistoryEntityMapper.toPlayerHistoryEntity(playerHistory);
        dynamoDbTemplate.save(playerHistoryEntity);
    }

}
