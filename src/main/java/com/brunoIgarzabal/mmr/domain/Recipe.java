package com.brunoIgarzabal.mmr.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public final class Recipe extends Base<Recipe> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String image;

    private Integer likes;
    private Integer views;

    private Integer timeInMinutes;
    private Integer servings;
    private Double calories;

    @ManyToMany(mappedBy = "recipes")
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    public Recipe() {}

    public Recipe(
            Integer id,
            String name,
            String image,
            Integer likes,
            Integer views,
            Integer timeInMinutes,
            Integer servings,
            Double calories,
            Difficulty difficulty
    ) {
        setId(id);
        this.name = name;
        this.timeInMinutes = timeInMinutes;
        this.image = image;
        this.likes = likes;
        this.servings = servings;
        this.calories = calories;
        this.views = views;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(Integer timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
