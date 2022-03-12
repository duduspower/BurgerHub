package com.example.BurgerApp.Controller;

import com.example.BurgerApp.Burger.Ingredient;

public interface IngredientByIdConverterRepo {
    Ingredient convert(String id);
}
