package com.rahul.Cricket.Application.tournament;


import com.rahul.Cricket.Application.match.Match;
import com.rahul.Cricket.Application.match.MatchRepository;
import com.rahul.Cricket.Application.match.MatchStatus;
import com.rahul.Cricket.Application.team.Team;
import com.rahul.Cricket.Application.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StandingsService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public List<GroupStandings> getAllStandings() {
        return List.of(
                buildGroupStandings("A"),
                buildGroupStandings("B")
        );
    }

    private GroupStandings buildGroupStandings(String groupName) {
        List<Team> teamsInGroup = teamRepository.findByGroupName(groupName);
        List<Match> completedMatches = matchRepository.findByGroupNameAndStatus(groupName, MatchStatus.COMPLETED);

        List<TeamStanding> standings = teamsInGroup.stream()
                .map(team -> buildTeamStanding(team, completedMatches))
                .sorted(Comparator.comparing(TeamStanding::getPoints).reversed())
                .toList();

        return new GroupStandings(groupName, standings);
    }

    private TeamStanding buildTeamStanding(Team team, List<Match> completedMatches) {
        int played = 0;
        int won = 0;

        for (Match match : completedMatches) {
            boolean playedThisMatch = match.getTeam1().getId().equals(team.getId())
                    || match.getTeam2().getId().equals(team.getId());

            if (playedThisMatch) {
                played++;
                if (match.getWinner() != null && match.getWinner().getId().equals(team.getId())) {
                    won++;
                }
            }
        }

        int lost = played - won;
        int points = won * 2;

        return new TeamStanding(team.getId(), team.getName(), played, won, lost, points);
    }
}