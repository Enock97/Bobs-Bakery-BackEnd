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
    private String description;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_post_id"))
    @Column(name = "ingredients")
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "recipe_instructions", joinColumns = @JoinColumn(name = "recipe_post_id"))
    @Column(name = "instructions")
    private List<String> instructions = new ArrayList<>();

    @Column
    private String category;

    @Column(name = "baking_time")
    private int bakingTime;

    @Column
    private int calories;

    @Column
    private String difficulty;

    @ElementCollection
    @CollectionTable(name = "recipe_tags", joinColumns = @JoinColumn(name = "recipe_post_id"))
    @Column(name = "tags")
    private List<String> recipeTags = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    @JsonIncludeProperties(value = {"id", "firstName", "lastName"})
    private User user;

    @OneToMany(mappedBy = "recipePost")
    @JsonIgnoreProperties(value = {"id", "recipePost"})
    public List<Review> reviews;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now(); // Optionally set the same as createdAt
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }


    public RecipePost(String title, String description, List<String> ingredients, List<String> instructions,
                      String category, int bakingTime, int calories, String difficulty,
                      List<String> recipeTags, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.description = description;
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
