package com.brunoIgarzabal.mmr.resources;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.dto.DifficultyDTO;
import com.brunoIgarzabal.mmr.services.DifficultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/difficulties")
@Tag(name = "Difficulty", description = "Level of preparation of recipes API")
public class DifficultyResource {

    @Autowired
    private DifficultyService service;

    @Operation(summary = "Find difficulty by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Difficulty> find(@PathVariable Integer id) {
        Difficulty difficulty = service.find(id);
        return ResponseEntity.ok().body(difficulty);
    }

    @Operation(summary = "Add a new difficulty")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody DifficultyDTO difficultyDto) {
        Difficulty difficulty = new Difficulty(difficultyDto.getId(), difficultyDto.getName(), difficultyDto.getLevel());
        difficulty = service.insert(difficulty);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(difficulty.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update an existing difficulty")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody DifficultyDTO difficultyDto, @PathVariable Integer id) {
        Difficulty difficulty = new Difficulty(difficultyDto.getId(), difficultyDto.getName(), difficultyDto.getLevel());
        difficulty.setId(id);
        difficulty = service.update(difficulty, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a difficulty")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Find all difficulties")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DifficultyDTO>> findAll() {
        List<Difficulty> list = service.findAll();

        List<DifficultyDTO> listDto = list
                .stream()
                .map(obj -> new DifficultyDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @Operation(summary = "Pagination of difficulties")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<DifficultyDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "level") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<Difficulty> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<DifficultyDTO> listDto = list
                .map(obj -> new DifficultyDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }
}
