package com.brunoIgarzabal.mmr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, Integer> {}
