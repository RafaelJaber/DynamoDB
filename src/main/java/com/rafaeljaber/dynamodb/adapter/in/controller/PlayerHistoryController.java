package com.rafaeljaber.dynamodb.adapter.in.controller;

import com.rafaeljaber.dynamodb.adapter.in.controller.mapper.PlayerHistoryRequestMapper;
import com.rafaeljaber.dynamodb.adapter.in.controller.request.PlayerHistoryRequest;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.CreatePlayerHistoryInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/player-history")
public class PlayerHistoryController {

    private final CreatePlayerHistoryInputPort createPlayerHistoryInputPort;
    private final PlayerHistoryRequestMapper playerHistoryRequestMapper;


    @PostMapping
    public ResponseEntity<Void> createPlayerHistory(@Valid @RequestBody PlayerHistoryRequest request) {
        PlayerHistory playerHistory = playerHistoryRequestMapper.toPlayerHistory(request);
        PlayerHistory created = createPlayerHistoryInputPort.create(playerHistory);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{username}/games/{gameId}")
                .buildAndExpand(created.getUsername(), created.getGameId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
