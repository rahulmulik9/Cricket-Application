package com.rahul.Cricket.Application.service;

import com.rahul.Cricket.Application.dto.MatchRequest;
import com.rahul.Cricket.Application.dto.MatchResponse;
import com.rahul.Cricket.Application.entity.Match;
import com.rahul.Cricket.Application.entity.MatchStatus;
import com.rahul.Cricket.Application.entity.Team;
import com.rahul.Cricket.Application.exception.BusinessRuleViolationException;
import com.rahul.Cricket.Application.exception.ResourceNotFoundException;
import com.rahul.Cricket.Application.repository.MatchRepository;
import com.rahul.Cricket.Application.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public MatchResponse createMatch(MatchRequest request) {
        if (request.getTeam1Id().equals(request.getTeam2Id())) {
            throw new BusinessRuleViolationException("A team cannot play against itself");
        }

        Team team1 = teamRepository.findById(request.getTeam1Id())
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + request.getTeam1Id()));

        Team team2 = teamRepository.findById(request.getTeam2Id())
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + request.getTeam2Id()));

        Match match = new Match();
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setGroupName(request.getGroupName());
        match.setMatchDate(request.getMatchDate());
        match.setVenue(request.getVenue());
        match.setStatus(MatchStatus.SCHEDULED);
        match.setMatchDate(request.getMatchDate());
        match.setMatchTime(request.getMatchTime());

        Match saved = matchRepository.save(match);
        return toResponse(saved);
    }

    public List<MatchResponse> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private MatchResponse toResponse(Match match) {
        return new MatchResponse(
                match.getId(),
                match.getTeam1().getId(),
                match.getTeam2().getId(),
                match.getGroupName(),
                match.getMatchDate(),
                match.getMatchTime(),
                match.getVenue(),
                match.getStatus()
        );
    }
}