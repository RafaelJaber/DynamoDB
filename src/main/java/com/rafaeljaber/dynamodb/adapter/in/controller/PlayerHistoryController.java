package com.rafaeljaber.dynamodb.adapter.in.controller;

import com.rafaeljaber.dynamodb.adapter.in.controller.mapper.PlayerHistoryRequestMapper;
import com.rafaeljaber.dynamodb.adapter.in.controller.mapper.PlayerHistoryResponseMapper;
import com.rafaeljaber.dynamodb.adapter.in.controller.request.PlayerHistoryRequest;
import com.rafaeljaber.dynamodb.adapter.in.controller.request.ScoreRequest;
import com.rafaeljaber.dynamodb.adapter.in.controller.response.PlayerHistoryResponse;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.CreatePlayerHistoryInputPort;
import com.rafaeljaber.dynamodb.application.ports.in.FindAllPlayerHistoriesByUsernameInputPort;
import com.rafaeljaber.dynamodb.application.ports.in.FindPlayerHistoryByGameIdInputPort;
import com.rafaeljaber.dynamodb.application.ports.in.UpdatePlayerHistoryByGameIdAndUsernameInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/player-history")
public class PlayerHistoryController {

    private final CreatePlayerHistoryInputPort createPlayerHistoryInputPort;
    private final FindAllPlayerHistoriesByUsernameInputPort findAllPlayerHistoriesByUsernameInputPort;
    private final FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort;
    private final PlayerHistoryRequestMapper playerHistoryRequestMapper;
    private final UpdatePlayerHistoryByGameIdAndUsernameInputPort updatePlayerHistoryByGameIdAndUsernameInputPort;
    private final PlayerHistoryResponseMapper playerHistoryResponseMapper;


    @GetMapping("/{username}")
    public ResponseEntity<List<PlayerHistoryResponse>> findAllPlayerHistoriesByUsername(
            @PathVariable String username
    ) {
        List<PlayerHistory> playerHistories = findAllPlayerHistoriesByUsernameInputPort.find(username);
        List<PlayerHistoryResponse> response = playerHistories.stream()
                .map(playerHistoryResponseMapper::toPlayerHistoryResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{username}/games/{gameId}")
    public ResponseEntity<PlayerHistoryResponse> findPlayerHistoryByGameId(
            @PathVariable String username,
            @PathVariable UUID gameId
    ) {
        PlayerHistory playerHistory = findPlayerHistoryByGameIdInputPort.find(username, gameId);
        PlayerHistoryResponse response = playerHistoryResponseMapper.toPlayerHistoryResponse(playerHistory);
        return ResponseEntity.ok(response);
    }


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

    @PutMapping("/{username}/games/{gameId}")
    public ResponseEntity<Void> updatePlayerHistory(
            @PathVariable String username,
            @PathVariable UUID gameId,
            @Valid @RequestBody ScoreRequest scoreRequest
    ) {
        updatePlayerHistoryByGameIdAndUsernameInputPort.update(username, gameId, scoreRequest.getScore());
        return ResponseEntity.noContent().build();
    }
}
