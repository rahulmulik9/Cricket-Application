package com.rahul.Cricket.Application.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(nullable = false)
    private String groupName; // "A" or "B"
}