package com.rahul.Cricket.Application.repository;

import com.rahul.Cricket.Application.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeamId(Long teamId);
    boolean existsByTeamIdAndJerseyNumber(Long teamId, Integer jerseyNumber);
    long countByTeamId(Long teamId);
}