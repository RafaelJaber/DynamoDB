package com.rafaeljaber.dynamodb.adapter.in.controller.mapper;

import com.rafaeljaber.dynamodb.adapter.in.controller.request.PlayerHistoryRequest;
import com.rafaeljaber.dynamodb.adapter.out.repository.entity.PlayerHistoryEntity;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerHistoryRequestMapper {


    @Mapping(target = "gameId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    PlayerHistory toPlayerHistory(PlayerHistoryRequest playerHistoryRequest);

}
