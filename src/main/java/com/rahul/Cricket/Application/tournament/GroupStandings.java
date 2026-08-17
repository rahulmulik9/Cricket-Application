package com.rahul.Cricket.Application.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GroupStandings {
    private String groupName;
    private List<TeamStanding> teams;
}
