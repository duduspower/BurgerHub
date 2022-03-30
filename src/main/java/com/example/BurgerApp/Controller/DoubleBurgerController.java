package com.example.BurgerApp.Controller;

import com.example.BurgerApp.Burger.Burger;
import com.example.BurgerApp.Burger.Ingredient;
import com.example.BurgerApp.Data.BurgerRepo;
import com.example.BurgerApp.Data.IngredientRepo;
import com.example.BurgerApp.Order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/doubleBurger")
public class DoubleBurgerController {

    private final IngredientRepo ingredientRepo;
    private BurgerRepo burgerRepo;

    @Autowired
    public DoubleBurgerController(IngredientRepo ingredientRepo, BurgerRepo burgerRepo){
        this.ingredientRepo = ingredientRepo;
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
        List<Ingredient> ingredients = doubleIngredient();

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
        }
        return "doubleBurger";
    }

    @PostMapping
    public String processDesign(@Valid Burger burger, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "doubleBurger";
        }
        Burger saved = burgerRepo.save(burger);
        order.addDesign(saved);

        return "redirect:/order";
    }

    public List<Ingredient> doubleIngredient(){
        ArrayList<Ingredient> doubleIngredients = new ArrayList<Ingredient>();
        doubleIngredients.add(new Ingredient("1",  "Wheat Bun", Ingredient.Type.BUM));
        doubleIngredients.add(new Ingredient("11", "100% Beef Patty", Ingredient.Type.MEAT));
        doubleIngredients.add(new Ingredient("11", "100% Beef Patty", Ingredient.Type.MEAT));
        doubleIngredients.add(new Ingredient("14", "Canadian Bacon", Ingredient.Type.MEAT));
        doubleIngredients.add(new Ingredient("14", "Canadian Bacon", Ingredient.Type.MEAT));
        doubleIngredients.add(new Ingredient("18", "Pasteurized Process American Cheese", Ingredient.Type.CHEESE));
        doubleIngredients.add(new Ingredient("18", "Pasteurized Process American Cheese", Ingredient.Type.CHEESE));
        doubleIngredients.add(new Ingredient("19", "Shredded Lettuce", Ingredient.Type.VEGETABLES));
        doubleIngredients.add(new Ingredient("21", "Onions", Ingredient.Type.VEGETABLES));
        doubleIngredients.add(new Ingredient("23", "Crinkle Cut Pickle", Ingredient.Type.VEGETABLES));
        doubleIngredients.add(new Ingredient("29", "Ketchup", Ingredient.Type.SAUCE));
        doubleIngredients.add(new Ingredient("30", "Mustard", Ingredient.Type.SAUCE));
        doubleIngredients.add(new Ingredient("31", "Mayonnaise", Ingredient.Type.SAUCE));
        doubleIngredients.add(new Ingredient("32", "Chicken Nuggets", Ingredient.Type.ADDITIVE));
        doubleIngredients.add(new Ingredient("33", "Fries", Ingredient.Type.ADDITIVE));
        doubleIngredients.add(new Ingredient("34", "OnionRings", Ingredient.Type.ADDITIVE));
        doubleIngredients.add(new Ingredient("35", "Apple Slices", Ingredient.Type.ADDITIVE));
        doubleIngredients.add(new Ingredient("36", "Coca-Cola", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("37", "Sprite", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("38", "Dr Pepper", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("39", "Fanta", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("40", "Diet Coke", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("41", "Ice-Tea", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("42", "Fuze-Tea", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("43", "Water", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("44", "Tymbark Orange", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("45", "Tymbark Apple", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("46", "Banana Juice", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("47", "Tea", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("48", "Coffe", Ingredient.Type.DRINK));
        doubleIngredients.add(new Ingredient("48", "Beer", Ingredient.Type.DRINK));

        return doubleIngredients;
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
