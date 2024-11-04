package com.rafaeljaber.dynamodb.adapter;

import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.adapter.out.repository.mapper.PlayerHistoryEntityMapper;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.out.FindAllPlayerHistoryByUsernameOutputPort;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllPlayerHistoriesByUsernameAdapter implements FindAllPlayerHistoryByUsernameOutputPort {

    private final DynamoDbTemplate dynamoDbTemplate;
    private final PlayerHistoryEntityMapper playerHistoryEntityMapper;

    @Override
    public List<PlayerHistory> find(String username) {
        Key key = Key.builder().partitionValue(username).build();
        QueryConditional condition = QueryConditional.keyEqualTo(key);

        QueryEnhancedRequest query = QueryEnhancedRequest.builder()
                .queryConditional(condition)
                .build();

        PageIterable<PlayerHistoryEntity> history = dynamoDbTemplate.query(query, PlayerHistoryEntity.class);

        return history.items().stream().map(playerHistoryEntityMapper::toPlayerHistory).toList();
    }

}
