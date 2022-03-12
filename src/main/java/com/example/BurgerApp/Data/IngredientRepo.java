package com.example.BurgerApp.Data;

import com.example.BurgerApp.Burger.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepo extends CrudRepository<Ingredient, String> {
}
