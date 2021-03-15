package com.brunoIgarzabal.mmr.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public final class UnitOfMeasurement extends Base<UnitOfMeasurement> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String symbol;
    private String plural;

    public UnitOfMeasurement() {

    }

    public UnitOfMeasurement(Integer id, String name, String symbol, String plural) {
        this.setId(id);
        this.name = name;
        this.symbol = symbol;
        this.plural = plural;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitOfMeasurement that = (UnitOfMeasurement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
