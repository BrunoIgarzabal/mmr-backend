package com.brunoIgarzabal.mmr.services;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.domain.UnitOfMeasurement;
import org.springframework.stereotype.Service;

@Service
public class UnitOfMeasurementService extends GenericService<UnitOfMeasurement>  {

    @Override
    protected void updateData(UnitOfMeasurement newObj, UnitOfMeasurement oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setSymbol(oldObj.getSymbol());
    }
}
