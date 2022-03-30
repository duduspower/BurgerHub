package com.example.BurgerApp.Burger;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Burger{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min=3, message = "Name must be longer than 3 characters")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must order at least 1 product")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist //przed zapisem
    void createdAt(){
        this.createdAt = new Date();
    }

    public Burger() {
    }

    public Burger(@NonNull String name, Date createdAt, List<Ingredient> ingredients) {
        this.name = name;
        this.createdAt = createdAt;
        this.ingredients = ingredients;
    }
}
