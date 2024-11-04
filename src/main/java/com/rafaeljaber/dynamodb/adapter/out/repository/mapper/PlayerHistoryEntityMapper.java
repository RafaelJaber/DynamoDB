package com.rafaeljaber.dynamodb.adapter.out.repository.mapper;

import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerHistoryEntityMapper {

    PlayerHistory toPlayerHistory(PlayerHistoryEntity playerHistoryEntity);

    PlayerHistoryEntity toPlayerHistoryEntity(PlayerHistory playerHistory);

}
