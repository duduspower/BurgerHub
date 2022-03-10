package com.example.BurgerApp.Burger;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Burger {

    @NonNull
    @Size(min=3, message = "Name must be longer than 3 characters")
    private String name;

    @Size(min = 2, message = "Your burger must contain more than 1 ingredient")
    private List<String> ingredients;

    public Burger() {

    }
}
