package com.example.BurgerApp.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import com.example.BurgerApp.Burger.Ingredient;
import com.example.BurgerApp.Burger.Ingredient.Type;
import com.example.BurgerApp.Burger.Burger;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @ModelAttribute
    public void addIgredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("1", "Wheat Bun", Type.BUM)
                , new Ingredient("2", "Potato Roll", Type.BUM)
                , new Ingredient("3", "Quarter Pound Bun", Type.BUM)
                , new Ingredient("4", "Regular Bun", Type.BUM)
                , new Ingredient("5", "English Muffin", Type.BUM)
                , new Ingredient("6", "Biscuit", Type.BUM)
                , new Ingredient("7", "Griddle Cakes", Type.BUM)

                , new Ingredient("8", "Chicken Filet", Type.MEAT)
                , new Ingredient("9", "Crispy Chicken Filet", Type.MEAT)
                , new Ingredient("10", "Fish Fillet Patty", Type.MEAT)
                , new Ingredient("11", "100% Beef Patty", Type.MEAT)
                , new Ingredient("12", "Quatter Pound 100% Beef Patty", Type.MEAT)
                , new Ingredient("13", "Thick Cut Applewood Smoked Bacon", Type.MEAT)
                , new Ingredient("14", "Canadian Bacon", Type.MEAT)
                , new Ingredient("15", "Sausage Patty", Type.MEAT)
                , new Ingredient("16", "Thick Cut Applewood Smoked Bacon", Type.MEAT)

                , new Ingredient("17", "Pasteurized Process American Cheese Half Slice", Type.CHEESE)
                , new Ingredient("18", "Pasteurized Process American Cheese", Type.CHEESE)

                , new Ingredient("19", "Shredded Lettuce", Type.VEGETABLES)
                , new Ingredient("20", "Pickle Slices", Type.VEGETABLES)
                , new Ingredient("21", "Onions", Type.VEGETABLES)
                , new Ingredient("22", "Roma Tomato", Type.VEGETABLES)
                , new Ingredient("23", "Crinkle Cut Pickle", Type.VEGETABLES)
                , new Ingredient("24", "Folded Egg", Type.VEGETABLES)
                , new Ingredient("25", "Egg", Type.VEGETABLES)

                , new Ingredient("26", "Salted Butter", Type.SAUCE)
                , new Ingredient("27", "Clarified Butter", Type.SAUCE)
                , new Ingredient("28", "Big Mac Sauce", Type.SAUCE)
                , new Ingredient("29", "Ketchup", Type.SAUCE)
                , new Ingredient("30", "Mustard", Type.SAUCE)
                , new Ingredient("31", "Mayonnaise", Type.SAUCE)

                , new Ingredient("32", "Chicken Nuggets", Type.ADDITIVE)
                , new Ingredient("33", "Fries", Type.ADDITIVE)
                , new Ingredient("34", "OnionRings", Type.ADDITIVE)
                , new Ingredient("35", "Apple Slices", Type.ADDITIVE)

                , new Ingredient("36", "Coca-Cola", Type.DRINK)
                , new Ingredient("37", "Sprite", Type.DRINK)
                , new Ingredient("38", "Dr Pepper", Type.DRINK)
                , new Ingredient("39", "Fanta", Type.DRINK)
                , new Ingredient("40", "Diet Coke", Type.DRINK)
                , new Ingredient("41", "Ice-Tea", Type.DRINK)
                , new Ingredient("42", "Fuze-Tea", Type.DRINK)
                , new Ingredient("43", "Water", Type.DRINK)
                , new Ingredient("44", "Tymbark Orange", Type.DRINK)
                , new Ingredient("45", "Tymbark Apple", Type.DRINK)
                , new Ingredient("46", "Banana Juice", Type.DRINK)
                , new Ingredient("47", "Tea", Type.DRINK)
                , new Ingredient("48", "Coffe", Type.DRINK)
                , new Ingredient("48", "Beer", Type.DRINK)

        );

        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model){
        model.addAttribute("design", new Burger());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Burger design, Errors errors, Model model){
        if(errors.hasErrors()){
            return "design";
        }
        log.info("Processing your Burger");
        return "redirect:/order";
    }





    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
