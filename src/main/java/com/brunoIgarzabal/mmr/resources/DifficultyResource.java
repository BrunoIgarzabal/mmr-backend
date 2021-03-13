package com.brunoIgarzabal.mmr.resources;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.services.DifficultyService;
import com.brunoIgarzabal.mmr.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/difficulties")
public class DifficultyResource {

    @Autowired
    private DifficultyService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Difficulty> find(@PathVariable Integer id) {
        Difficulty difficulty = service.find(id);
        return ResponseEntity.ok().body(difficulty);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Difficulty difficulty) {
        difficulty = service.insert(difficulty);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(difficulty.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Difficulty difficulty, @PathVariable Integer id) {
        difficulty.setId(id);
        difficulty = service.update(difficulty, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
