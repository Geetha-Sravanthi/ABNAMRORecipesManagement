package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Dao.IRecipesDao;
@SpringBootApplication
public class RecipeManagementApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RecipeManagementApplication.class, args);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RecipeManagementApplication.class,
				args);
		IRecipesDao recipesRepository = applicationContext.getBean(IRecipesDao.class);
		/*Ingredients ingredients=new Ingredients();
		ingredients.setIngredients("abcd");
		
		Ingredients ingredients1=new Ingredients();
		ingredients1.setIngredients("abc");
		
		List<Ingredients> list = List.of(ingredients,ingredients1);
		
		Recipe recipe = new Recipe();
		recipe.setName("test");
		recipe.setServings(3);
		recipe.setInstructions("testet");
		recipe.setIngredients(list);
		recipe.setVeg(true);
		
		recipeRepository.save(recipe);*/
		
		
	}
	
	
	
	
}
