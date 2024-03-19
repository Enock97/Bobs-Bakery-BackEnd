package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe_posts")
public class RecipePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private List<String> ingredients;

    @Column
    private List<String> instructions;

    @Column
    private String category;

    @Column(name = "baking_time")
    private int bakingTime;

    @Column
    private int calories;

    @Column
    private String difficulty;

    @Column(name = "recipe_tags")
    private List<String> recipeTags;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    @JsonIncludeProperties(value = {"id", "firstName", "lastName"})
    private User user;

    @OneToMany(mappedBy = "recipePost")
    @JsonIgnoreProperties(value = {"id", "recipePost"})
    public List<Review> reviews;



    public RecipePost(String title, List<String> ingredients, List<String> instructions,
                      String category, int bakingTime, int calories, String difficulty,
                      List<String> recipeTags, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.bakingTime = bakingTime;
        this.calories = calories;
        this.difficulty = difficulty;
        this.recipeTags = recipeTags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
