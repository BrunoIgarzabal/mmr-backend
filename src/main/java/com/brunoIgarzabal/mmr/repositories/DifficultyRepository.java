package com.brunoIgarzabal.mmr.repositories;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Integer> {
}
