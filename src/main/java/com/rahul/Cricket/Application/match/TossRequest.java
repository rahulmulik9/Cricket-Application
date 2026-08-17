package com.rahul.Cricket.Application.match;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TossRequest {
    @NotNull(message = "Toss winner team ID is required")
    private Long tossWinnerTeamId;

    @NotNull(message = "Toss decision (BAT or BOWL) is required")
    private TossDecision tossDecision;
}