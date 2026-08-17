package com.rahul.Cricket.Application.team;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamResponse {
    private Long id;
    private String name;
    private String shortName;
    private String groupName;
}