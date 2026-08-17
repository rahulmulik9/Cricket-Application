package com.rahul.Cricket.Application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequest {
    @NotBlank(message = "Player name is required")
    private String name;

    @NotNull(message = "Jersey number is required")
    private Integer jerseyNumber;
}