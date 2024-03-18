package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String message;

    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    @JsonIncludeProperties(value = {"id", "firstName", "lastName"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_post_id", nullable = false )
    @JsonIncludeProperties(value = {"id", "title","category"})
    private RecipePost recipePost;

    public Review(String message, int rating) {
        this.message = message;
        this.rating = rating;
    }
}

