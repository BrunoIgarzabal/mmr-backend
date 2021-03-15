package com.brunoIgarzabal.mmr.dto;

import com.brunoIgarzabal.mmr.domain.UnitOfMeasurement;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public final class UnitOfMeasurementDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @NotEmpty(message = "Símbolo é obrigatório")
    private String symbol;

    @NotEmpty(message = "Nome no plural é obrigatório")
    private String plural;

    public UnitOfMeasurementDTO() {

    }

    public UnitOfMeasurementDTO(UnitOfMeasurement unitOfMeasurement) {
        this.symbol = unitOfMeasurement.getSymbol();
        this.name = unitOfMeasurement.getName();
        this.plural = unitOfMeasurement.getPlural();
        this.setId(unitOfMeasurement.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }
}
