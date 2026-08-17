package com.rahul.Cricket.Application.team;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamRequest {
    @NotBlank(message = "Team name is required")
    private String name;

    private String shortName;

    @NotBlank(message = "Group is required")
    private String groupName;
}