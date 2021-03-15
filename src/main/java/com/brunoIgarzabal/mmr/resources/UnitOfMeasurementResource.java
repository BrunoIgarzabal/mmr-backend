package com.brunoIgarzabal.mmr.resources;

import com.brunoIgarzabal.mmr.domain.UnitOfMeasurement;
import com.brunoIgarzabal.mmr.dto.UnitOfMeasurementDTO;
import com.brunoIgarzabal.mmr.services.UnitOfMeasurementService;
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
@RequestMapping(value = "/unitsOfMeasurements")
public class UnitOfMeasurementResource {

    @Autowired
    private UnitOfMeasurementService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UnitOfMeasurement> find(@PathVariable Integer id) {
        UnitOfMeasurement unitOfMeasurement = service.find(id);
        return ResponseEntity.ok().body(unitOfMeasurement);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody UnitOfMeasurementDTO unitOfMeasurementDTO) {
        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement(unitOfMeasurementDTO.getId(), unitOfMeasurementDTO.getName(), unitOfMeasurementDTO.getSymbol(), unitOfMeasurementDTO.getPlural());
        unitOfMeasurement = service.insert(unitOfMeasurement);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(unitOfMeasurement.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody UnitOfMeasurementDTO unitOfMeasurementDTO, @PathVariable Integer id) {
        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement(unitOfMeasurementDTO.getId(), unitOfMeasurementDTO.getName(), unitOfMeasurementDTO.getSymbol(), unitOfMeasurementDTO.getPlural());
        unitOfMeasurement.setId(id);

        unitOfMeasurement = service.update(unitOfMeasurement, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UnitOfMeasurementDTO>> findAll() {
        List<UnitOfMeasurement> list = service.findAll();

        List<UnitOfMeasurementDTO> listDto = list
                .stream()
                .map(obj -> new UnitOfMeasurementDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<UnitOfMeasurementDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<UnitOfMeasurement> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<UnitOfMeasurementDTO> listDto = list
                .map(obj -> new UnitOfMeasurementDTO(obj));

        return ResponseEntity.ok().body(listDto);
    }
}
