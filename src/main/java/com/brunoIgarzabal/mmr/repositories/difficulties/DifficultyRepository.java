package com.brunoIgarzabal.mmr.repositories.difficulties;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface DifficultyRepository extends GenericRepository<Difficulty> {
}
