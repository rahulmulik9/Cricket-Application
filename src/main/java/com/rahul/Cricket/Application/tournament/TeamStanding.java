package com.rahul.Cricket.Application.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamStanding {
    private Long teamId;
    private String teamName;
    private Integer played;
    private Integer won;
    private Integer lost;
    private Integer points;
}