package com.rafaeljaber.dynamodb.adapter.in.controller.mapper;

import com.rafaeljaber.dynamodb.adapter.in.controller.response.PlayerHistoryResponse;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerHistoryResponseMapper {

    PlayerHistoryResponse toPlayerHistoryResponse(PlayerHistory playerHistory);

}
