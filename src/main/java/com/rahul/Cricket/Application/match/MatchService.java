package com.rahul.Cricket.Application.match;

import com.rahul.Cricket.Application.team.Team;
import com.rahul.Cricket.Application.common.exception.BusinessRuleViolationException;
import com.rahul.Cricket.Application.common.exception.ResourceNotFoundException;
import com.rahul.Cricket.Application.team.TeamRepository;
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
        Long tossWinnerId = match.getTossWinner() != null ? match.getTossWinner().getId() : null;

        return new MatchResponse(
                match.getId(),
                match.getTeam1().getId(),
                match.getTeam2().getId(),
                match.getGroupName(),
                match.getMatchDate(),
                match.getMatchTime(),
                match.getVenue(),
                match.getStatus(),
                tossWinnerId,
                match.getTossDecision()
        );
    }

    public MatchResponse getMatchById(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + id));
        return toResponse(match);
    }
    public MatchResponse recordToss(Long matchId, TossRequest request) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + matchId));

        if (match.getStatus() != MatchStatus.SCHEDULED) {
            throw new BusinessRuleViolationException(
                    "Toss can only be recorded for a SCHEDULED match. Current status: " + match.getStatus()
            );
        }

        Long team1Id = match.getTeam1().getId();
        Long team2Id = match.getTeam2().getId();
        Long tossWinnerId = request.getTossWinnerTeamId();

        if (!tossWinnerId.equals(team1Id) && !tossWinnerId.equals(team2Id)) {
            throw new BusinessRuleViolationException(
                    "Toss winner must be one of the two teams playing this match"
            );
        }

        Team tossWinner = teamRepository.findById(tossWinnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + tossWinnerId));

        match.setTossWinner(tossWinner);
        match.setTossDecision(request.getTossDecision());

        Match saved = matchRepository.save(match);
        return toResponse(saved);
    }
}