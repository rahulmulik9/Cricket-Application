package com.rahul.Cricket.Application.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "players",
        uniqueConstraints = @UniqueConstraint(columnNames = {"team_id", "jersey_number"})
)
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "jersey_number", nullable = false)
    private Integer jerseyNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}