package com.rahul.Cricket.Application.repository;

import com.rahul.Cricket.Application.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
