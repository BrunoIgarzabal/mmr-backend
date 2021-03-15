package com.brunoIgarzabal.mmr.services;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import org.springframework.stereotype.Service;

@Service
public class DifficultyService extends GenericService<Difficulty> {

    @Override
    protected void updateData(Difficulty newObj, Difficulty oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setLevel(oldObj.getLevel());
    }
}
