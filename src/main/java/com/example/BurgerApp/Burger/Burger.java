package com.example.BurgerApp.Burger;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Burger {

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

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    public Burger() {
    }
}
