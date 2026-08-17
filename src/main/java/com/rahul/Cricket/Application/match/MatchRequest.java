package com.rahul.Cricket.Application.match;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MatchRequest {
    @NotNull(message = "Team1 ID is required")
    private Long team1Id;

    @NotNull(message = "Team2 ID is required")
    private Long team2Id;

    @NotBlank(message = "Group is required")
    private String groupName;

    @NotNull(message = "Match date is required")
    private LocalDate matchDate;

    @NotNull(message = "Match time is required")
    private LocalTime matchTime;

    @NotBlank(message = "Venue is required")
    private String venue;
}