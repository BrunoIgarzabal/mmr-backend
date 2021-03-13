package com.brunoIgarzabal.mmr.services;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.repositories.DifficultyRepository;
import com.brunoIgarzabal.mmr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DifficultyService {

    @Autowired
    private DifficultyRepository difficultyRepository;

    public Difficulty find(Integer id) {
        Optional<Difficulty> obj = difficultyRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Difficulty.class.getName()
        ));
    }
}
