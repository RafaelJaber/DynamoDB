package com.rafaeljaber.dynamodb.adapter.in.controller;

import com.rafaeljaber.dynamodb.adapter.in.controller.mapper.PlayerHistoryRequestMapper;
import com.rafaeljaber.dynamodb.adapter.in.controller.mapper.PlayerHistoryResponseMapper;
import com.rafaeljaber.dynamodb.adapter.in.controller.request.PlayerHistoryRequest;
import com.rafaeljaber.dynamodb.adapter.in.controller.request.ScoreRequest;
import com.rafaeljaber.dynamodb.adapter.in.controller.response.PlayerHistoryResponse;
import com.rafaeljaber.dynamodb.application.core.domain.PlayerHistory;
import com.rafaeljaber.dynamodb.application.ports.in.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "PlayerHistory", description = "API para gerenciamento de históricos de jogadores")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/player-history")
public class PlayerHistoryController {

    private final CreatePlayerHistoryInputPort createPlayerHistoryInputPort;
    private final FindAllPlayerHistoriesByUsernameInputPort findAllPlayerHistoriesByUsernameInputPort;
    private final FindPlayerHistoryByGameIdInputPort findPlayerHistoryByGameIdInputPort;
    private final PlayerHistoryRequestMapper playerHistoryRequestMapper;
    private final UpdatePlayerHistoryByGameIdAndUsernameInputPort updatePlayerHistoryByGameIdAndUsernameInputPort;
    private final DeletePlayerHistoryByGameIdAndUsernameInputPort deletePlayerHistoryByGameIdAndUsernameInputPort;
    private final PlayerHistoryResponseMapper playerHistoryResponseMapper;

    @Operation(summary = "Busca todos os históricos de um jogador pelo username")
    @GetMapping("/{username}")
    public ResponseEntity<List<PlayerHistoryResponse>> findAllPlayerHistoriesByUsername(
            @Parameter(description = "Username do jogador", required = true)
            @PathVariable String username
    ) {
        List<PlayerHistory> playerHistories = findAllPlayerHistoriesByUsernameInputPort.find(username);
        List<PlayerHistoryResponse> response = playerHistories.stream()
                .map(playerHistoryResponseMapper::toPlayerHistoryResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca o histórico de um jogador por game ID")
    @GetMapping("/{username}/games/{gameId}")
    public ResponseEntity<PlayerHistoryResponse> findPlayerHistoryByGameId(
            @Parameter(description = "Username do jogador", required = true)
            @PathVariable String username,
            @Parameter(description = "ID do jogo", required = true)
            @PathVariable UUID gameId
    ) {
        PlayerHistory playerHistory = findPlayerHistoryByGameIdInputPort.find(username, gameId);
        PlayerHistoryResponse response = playerHistoryResponseMapper.toPlayerHistoryResponse(playerHistory);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo histórico para um jogador")
    @PostMapping
    public ResponseEntity<Void> createPlayerHistory(
            @Valid @RequestBody PlayerHistoryRequest request
    ) {
        PlayerHistory playerHistory = playerHistoryRequestMapper.toPlayerHistory(request);
        PlayerHistory created = createPlayerHistoryInputPort.create(playerHistory);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{username}/games/{gameId}")
                .buildAndExpand(created.getUsername(), created.getGameId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Atualiza o histórico de um jogador por game ID e username")
    @PutMapping("/{username}/games/{gameId}")
    public ResponseEntity<Void> updatePlayerHistory(
            @Parameter(description = "Username do jogador", required = true)
            @PathVariable String username,
            @Parameter(description = "ID do jogo", required = true)
            @PathVariable UUID gameId,
            @Valid @RequestBody ScoreRequest scoreRequest
    ) {
        updatePlayerHistoryByGameIdAndUsernameInputPort.update(username, gameId, scoreRequest.getScore());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deleta o histórico de um jogador por game ID e username")
    @DeleteMapping("/{username}/games/{gameId}")
    public ResponseEntity<Void> deletePlayerHistory(
            @Parameter(description = "Username do jogador", required = true)
            @PathVariable String username,
            @Parameter(description = "ID do jogo", required = true)
            @PathVariable UUID gameId
    ) {
        deletePlayerHistoryByGameIdAndUsernameInputPort.delete(username, gameId);
        return ResponseEntity.noContent().build();
    }
}