package com.example.BurgerApp.Controller;

import com.example.BurgerApp.Burger.Ingredient;
import com.example.BurgerApp.Data.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements IngredientByIdConverterRepo {

    private IngredientRepo ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepo ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id){
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.isPresent() ? optionalIngredient.get() : null;
    }

}
