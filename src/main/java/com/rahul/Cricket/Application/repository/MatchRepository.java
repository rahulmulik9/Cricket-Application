package com.rahul.Cricket.Application.repository;

import com.rahul.Cricket.Application.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}