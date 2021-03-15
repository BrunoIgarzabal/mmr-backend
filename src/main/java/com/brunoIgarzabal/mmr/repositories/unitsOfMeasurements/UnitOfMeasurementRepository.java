package com.brunoIgarzabal.mmr.repositories.unitsOfMeasurements;

import com.brunoIgarzabal.mmr.domain.UnitOfMeasurement;
import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasurementRepository extends GenericRepository<UnitOfMeasurement> {
}
