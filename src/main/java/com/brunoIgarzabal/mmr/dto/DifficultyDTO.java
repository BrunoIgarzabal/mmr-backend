package com.brunoIgarzabal.mmr.dto;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class DifficultyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Name is Required")
    private String name;

    @NotEmpty(message = "Level is Required")
    private String level;

    public DifficultyDTO() {

    }

    public DifficultyDTO(Difficulty difficulty) {
        this.level = difficulty.getLevel();
        this.name = difficulty.getName();
        setId(difficulty.getId());
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
