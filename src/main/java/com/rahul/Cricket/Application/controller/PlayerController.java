package com.rahul.Cricket.Application.controller;

import com.rahul.Cricket.Application.dto.PlayerRequest;
import com.rahul.Cricket.Application.dto.PlayerResponse;
import com.rahul.Cricket.Application.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams/{teamId}/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(
            @PathVariable Long teamId,
            @Valid @RequestBody PlayerRequest request) {
        PlayerResponse response = playerService.addPlayer(teamId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayers(@PathVariable Long teamId) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(teamId));
    }
}