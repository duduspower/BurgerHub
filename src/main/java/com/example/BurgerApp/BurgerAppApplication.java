package com.example.BurgerApp;

import com.example.BurgerApp.Data.IngredientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.example.BurgerApp.Burger.Ingredient.Type;
import com.example.BurgerApp.Burger.Ingredient;

import java.util.ArrayList;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class BurgerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepo repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Ingredient("1", "Wheat Bun", Type.BUM));
				repo.save(new Ingredient("2", "Potato Roll", Type.BUM));
				repo.save(new Ingredient("3", "Quarter Pound Bun", Type.BUM));
				repo.save(new Ingredient("4", "Regular Bun", Type.BUM));
				repo.save(new Ingredient("5", "English Muffin", Type.BUM));
				repo.save(new Ingredient("6", "Biscuit", Type.BUM));
				repo.save(new Ingredient("7", "Griddle Cakes", Type.BUM));

				repo.save(new Ingredient("8", "Chicken Filet", Type.MEAT));
				repo.save(new Ingredient("9", "Crispy Chicken Filet", Type.MEAT));
				repo.save(new Ingredient("10", "Fish Fillet Patty", Type.MEAT));
				repo.save(new Ingredient("11", "100% Beef Patty", Type.MEAT));
				repo.save(new Ingredient("12", "Quatter Pound 100% Beef Patty", Type.MEAT));
				repo.save(new Ingredient("13", "Thick Cut Applewood Smoked Bacon", Type.MEAT));
				repo.save(new Ingredient("14", "Canadian Bacon", Type.MEAT));
				repo.save(new Ingredient("15", "Sausage Patty", Type.MEAT));
				repo.save(new Ingredient("16", "Thick Cut Applewood Smoked Bacon", Type.MEAT));

				repo.save(new Ingredient("17", "Pasteurized Process American Cheese Half Slice", Type.CHEESE));
				repo.save(new Ingredient("18", "Pasteurized Process American Cheese", Type.CHEESE));

				repo.save(new Ingredient("19", "Shredded Lettuce", Type.VEGETABLES));
				repo.save(new Ingredient("20", "Pickle Slices", Type.VEGETABLES));
				repo.save(new Ingredient("21", "Onions", Type.VEGETABLES));
				repo.save(new Ingredient("22", "Roma Tomato", Type.VEGETABLES));
				repo.save(new Ingredient("23", "Crinkle Cut Pickle", Type.VEGETABLES));
				repo.save(new Ingredient("24", "Folded Egg", Type.VEGETABLES));
				repo.save(new Ingredient("25", "Egg", Type.VEGETABLES));

				repo.save(new Ingredient("26", "Salted Butter", Type.SAUCE));
				repo.save(new Ingredient("27", "Clarified Butter", Type.SAUCE));
				repo.save(new Ingredient("28", "Big Mac Sauce", Type.SAUCE));
				repo.save(new Ingredient("29", "Ketchup", Type.SAUCE));
				repo.save(new Ingredient("30", "Mustard", Type.SAUCE));
				repo.save(new Ingredient("31", "Mayonnaise", Type.SAUCE));

				repo.save(new Ingredient("32", "Chicken Nuggets", Type.ADDITIVE));
				repo.save(new Ingredient("33", "Fries", Type.ADDITIVE));
				repo.save(new Ingredient("34", "OnionRings", Type.ADDITIVE));
				repo.save(new Ingredient("35", "Apple Slices", Type.ADDITIVE));

				repo.save(new Ingredient("36", "Coca-Cola", Type.DRINK));
				repo.save(new Ingredient("37", "Sprite", Type.DRINK));
				repo.save(new Ingredient("38", "Dr Pepper", Type.DRINK));
				repo.save(new Ingredient("39", "Fanta", Type.DRINK));
				repo.save(new Ingredient("40", "Diet Coke", Type.DRINK));
				repo.save(new Ingredient("41", "Ice-Tea", Type.DRINK));
				repo.save(new Ingredient("42", "Fuze-Tea", Type.DRINK));
				repo.save(new Ingredient("43", "Water", Type.DRINK));
				repo.save(new Ingredient("44", "Tymbark Orange", Type.DRINK));
				repo.save(new Ingredient("45", "Tymbark Apple", Type.DRINK));
				repo.save(new Ingredient("46", "Banana Juice", Type.DRINK));
				repo.save(new Ingredient("47", "Tea", Type.DRINK));
				repo.save(new Ingredient("48", "Coffe", Type.DRINK));
				repo.save(new Ingredient("48", "Beer", Type.DRINK));
			}
		};
	}
}
