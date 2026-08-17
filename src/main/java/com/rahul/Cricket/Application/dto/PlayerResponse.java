package com.rahul.Cricket.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerResponse {
    private Long id;
    private String name;
    private Integer jerseyNumber;
    private Long teamId;
}