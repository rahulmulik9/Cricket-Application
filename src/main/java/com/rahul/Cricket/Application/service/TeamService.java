package com.rahul.Cricket.Application.service;

import com.rahul.Cricket.Application.dto.TeamRequest;
import com.rahul.Cricket.Application.dto.TeamResponse;
import com.rahul.Cricket.Application.entity.Team;
import com.rahul.Cricket.Application.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamResponse createTeam(TeamRequest request) {
        Team team = new Team();
        team.setName(request.getName());
        team.setShortName(request.getShortName());
        team.setGroupName(request.getGroupName());

        Team saved = teamRepository.save(team);
        return toResponse(saved);
    }

    public List<TeamResponse> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private TeamResponse toResponse(Team team) {
        return new TeamResponse(team.getId(), team.getName(), team.getShortName(), team.getGroupName());
    }
}