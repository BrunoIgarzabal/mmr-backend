package com.brunoIgarzabal.mmr.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public final class PreparationModeRecipe extends Base<PreparationModeRecipe> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer orderPreparation;
    private String description;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public PreparationModeRecipe() {}

    public PreparationModeRecipe(Integer id, Integer order, String description, Recipe recipe) {
        setId(id);
        this.orderPreparation = order;
        this.description = description;
        this.recipe = recipe;
    }

    public Integer getOrderPreparation() {
        return orderPreparation;
    }

    public void setOrderPreparation(Integer orderPreparation) {
        this.orderPreparation = orderPreparation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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
