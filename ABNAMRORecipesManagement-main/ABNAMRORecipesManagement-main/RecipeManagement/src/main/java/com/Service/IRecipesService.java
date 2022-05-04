package com.Service;
import java.util.List;
import com.Entity.Recipes;

public interface IRecipesService {

	List<Recipes> getall();
	String createRecipes(Recipes rec);
	String deleteById(int id);
	Recipes viewRecipes(int recId);
	Recipes updateRecipes(Recipes recipe, int id);
}
