package com.rahul.Cricket.Application.player;

import com.rahul.Cricket.Application.team.Team;
import com.rahul.Cricket.Application.common.exception.BusinessRuleViolationException;
import com.rahul.Cricket.Application.common.exception.ResourceNotFoundException;
import com.rahul.Cricket.Application.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private static final int MAX_SQUAD_SIZE = 7;

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerResponse addPlayer(Long teamId, PlayerRequest request) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));

        long currentSquadSize = playerRepository.countByTeamId(teamId);
        if (currentSquadSize >= MAX_SQUAD_SIZE) {
            throw new BusinessRuleViolationException(
                    "Team already has the maximum squad size of " + MAX_SQUAD_SIZE + " players"
            );
        }

        if (playerRepository.existsByTeamIdAndJerseyNumber(teamId, request.getJerseyNumber())) {
            throw new BusinessRuleViolationException(
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
        teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));

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