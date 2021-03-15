package com.brunoIgarzabal.mmr.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public final class Difficulty extends Base<Difficulty> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String level;

    public Difficulty() {

    }

    public Difficulty(Integer id, String name, String level) {
        this.setId(id);
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Difficulty that = (Difficulty) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
