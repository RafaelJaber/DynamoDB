package com.rafaeljaber.dynamodb.adapter;

import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.adapter.out.repository.mapper.PlayerHistoryEntityMapper;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.out.CreatePlayerHistoryOutputPort;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePlayerHistoryAdapter implements CreatePlayerHistoryOutputPort {

    private final DynamoDbTemplate dynamoDbTemplate;
    private final PlayerHistoryEntityMapper playerHistoryEntityMapper;


    @Override
    public PlayerHistory create(PlayerHistory playerHistory) {
        PlayerHistoryEntity entity = playerHistoryEntityMapper.toPlayerHistoryEntity(playerHistory);
        PlayerHistoryEntity saved = dynamoDbTemplate.save(entity);
        return playerHistoryEntityMapper.toPlayerHistory(saved);
    }

}
