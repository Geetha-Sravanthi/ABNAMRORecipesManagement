package com;



import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.Dao.IRecipesDao;
import com.Entity.Ingredients;
import com.Entity.Recipes;
import com.Service.IRecipesService;


@SpringBootTest
public class RecipesTest extends RecipeManagementApplicationTests {
	
	
	@MockBean
	IRecipesDao irecipesDao;
	
	@Autowired
	private IRecipesService irecipesService;
	
	private Recipes getrecipes() {
		Ingredients ingredients = new Ingredients();
		ingredients.setIngredients("spicy");
		Ingredients ingredient1 = new Ingredients();
		ingredient1.setIngredients("salt");
		List<Ingredients> list = List.of(ingredients,ingredient1);
		
		Recipes recipes = new Recipes();
		
		
		recipes.setId(1);
		recipes.setName("noodles");
		recipes.setLocaldatetime(LocalDateTime.now());
		recipes.setVegetarian(true);
		recipes.setServings(4);
		recipes.setIngredients(list);
		recipes.setInstructions("recipe for 4 members");
		return recipes;
		
	}
	@Test
	void testcreateRecipes() throws Exception{
		Recipes recipes = getrecipes();
		when(irecipesDao.save(recipes)).thenReturn(recipes);
		assertNotNull(recipes);
	
	}
	
	@Test
	void updateRecipe() throws Exception {
		Recipes recipes = getrecipes();
		recipes.setName("Chilli panir tikka");
		recipes.setInstructions("ABC");
		when(irecipesDao.findById(recipes.getId())).thenReturn(Optional.of(recipes));
		
		when(irecipesDao.save(recipes)).thenReturn(recipes);
		assertThat(irecipesService.updateRecipes(recipes,1)).isEqualTo(recipes);
	}
	 
		@Test
		void GetRecipe() throws Exception{
			Recipes recipe = getrecipes();
			
			//String RecipeName = "Panir tikka";
			int Id = 1;
			//Optional<recipes> recipe1 = recipeRepository.findByRecipeName(recipe.getRecipeName());
			when(irecipesDao.findById(1)).thenReturn(Optional.of(recipe));
			assertEquals(recipe,irecipesService.viewRecipes(recipe.getId()));
		}
	@Test
	void DeleteRecipe() throws Exception{
		Recipes recipes = getrecipes();
	    when(irecipesDao.findById(1)).thenReturn(Optional.of(recipes));
	    irecipesService.deleteById(1);
	    verify(irecipesDao,times(1)).deleteById(1);
	}
	

}
