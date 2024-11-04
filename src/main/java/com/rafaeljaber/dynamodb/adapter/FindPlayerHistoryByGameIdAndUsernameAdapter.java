package com.rafaeljaber.dynamodb.adapter;

import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.adapter.out.repository.mapper.PlayerHistoryEntityMapper;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.out.FindPlayerHistoryByGameIdAndUsernameOutputPort;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindPlayerHistoryByGameIdAndUsernameAdapter implements FindPlayerHistoryByGameIdAndUsernameOutputPort {

    private final DynamoDbTemplate dynamoDbTemplate;
    private final PlayerHistoryEntityMapper playerHistoryEntityMapper;


    @Override
    public Optional<PlayerHistory> find(String username, UUID gameId) {
        PlayerHistoryEntity entity = dynamoDbTemplate.load(Key.builder()
                        .partitionValue(username)
                        .sortValue(gameId.toString())
                .build(), PlayerHistoryEntity.class);

        return Optional.ofNullable(entity).map(playerHistoryEntityMapper::toPlayerHistory);
    }
}
