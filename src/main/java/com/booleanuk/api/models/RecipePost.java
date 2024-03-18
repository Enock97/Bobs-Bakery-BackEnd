package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
    private ArrayList<String> ingredients;

    @Column
    private ArrayList<String> instructions;

    @Column
    private String category;

    @Column(name = "baking_time")
    private int bakingTime;

    @Column
    private int calories;

    @Column
    private String difficulty;

    @Column(name = "recipe_tags")
    private ArrayList<String> recipeTags;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    @JsonIncludeProperties(value = {"id"})
    private User user;

    public RecipePost(String title, ArrayList<String> ingredients, ArrayList<String> instructions, String category, int bakingTime, int calories, String difficulty, ArrayList<String> recipeTags) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
        this.bakingTime = bakingTime;
        this.calories = calories;
        this.difficulty = difficulty;
        this.recipeTags = recipeTags;
    }
}
