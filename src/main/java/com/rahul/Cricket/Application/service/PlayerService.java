package com.rahul.Cricket.Application.service;

import com.rahul.Cricket.Application.dto.PlayerRequest;
import com.rahul.Cricket.Application.dto.PlayerResponse;
import com.rahul.Cricket.Application.entity.Player;
import com.rahul.Cricket.Application.entity.Team;
import com.rahul.Cricket.Application.repository.PlayerRepository;
import com.rahul.Cricket.Application.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerResponse addPlayer(Long teamId, PlayerRequest request) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));

        if (playerRepository.existsByTeamIdAndJerseyNumber(teamId, request.getJerseyNumber())) {
            throw new RuntimeException(
                    "Jersey number " + request.getJerseyNumber() + " already used in this team"
            );
        }

        Player player = new Player();
        player.setName(request.getName());
        player.setJerseyNumber(request.getJerseyNumber());
        player.setTeam(team);

        Player saved = playerRepository.save(player);
        return toResponse(saved);
    }

    public List<PlayerResponse> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private PlayerResponse toResponse(Player player) {
        return new PlayerResponse(
                player.getId(),
                player.getName(),
                player.getJerseyNumber(),
                player.getTeam().getId()
        );
    }
}