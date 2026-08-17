package com.rahul.Cricket.Application.dto;

import com.rahul.Cricket.Application.entity.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class MatchResponse {
    private Long id;
    private Long team1Id;
    private Long team2Id;
    private String groupName;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String venue;
    private MatchStatus status;
}