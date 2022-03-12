package com.example.BurgerApp.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.BurgerApp.Data.BurgerRepo;
import com.example.BurgerApp.Data.IngredientRepo;
import com.example.BurgerApp.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import com.example.BurgerApp.Burger.Ingredient;
import com.example.BurgerApp.Burger.Ingredient.Type;
import com.example.BurgerApp.Burger.Burger;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignController {

    private final IngredientRepo ingredientRepo;
    private BurgerRepo burgerRepo;

    @Autowired
    public DesignController(IngredientRepo ingredientRepo, BurgerRepo burgerRepo){
        this.ingredientRepo= ingredientRepo;
        this.burgerRepo = burgerRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Burger design(){
        return new Burger();
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Burger burger, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }

        Burger saved = burgerRepo.save(burger);
        order.addDesign(saved);

        return "redirect:/order";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    public BurgerRepo getBurgerRepo() {
        return burgerRepo;
    }
}
