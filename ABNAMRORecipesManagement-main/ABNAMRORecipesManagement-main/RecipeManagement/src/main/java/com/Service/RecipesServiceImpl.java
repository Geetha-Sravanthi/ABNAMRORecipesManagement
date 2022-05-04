package com.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.IRecipesDao;
import com.Entity.Recipes;
@Service
public class RecipesServiceImpl implements IRecipesService {
	
	@Autowired
	IRecipesDao iRecipesDao;
	@Override
	public String createRecipes(Recipes rec) {
		// TODO Auto-generated method stub
		iRecipesDao.save(rec);
		return "recipe created sucessfully";
	}

	@Override
	public Recipes updateRecipes(Recipes recipes,int id) {
	// TODO Auto-generated method stub
	Recipes updatedRecipe =iRecipesDao.findById(id).get();
	updatedRecipe.setName(recipes.getName());
	updatedRecipe.setIngredients(recipes.getIngredients());
	updatedRecipe.setInstructions(recipes.getInstructions());
	updatedRecipe.setLocaldatetime(recipes.getLocaldatetime());
	updatedRecipe.setServings(recipes.getServings());
	return iRecipesDao.save(updatedRecipe);
	}
    @Override
	public List<Recipes> getall() {
		// TODO Auto-generated method stub
		return iRecipesDao.findAll();
	}

	@Override
	
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		iRecipesDao.deleteById(id);
		return "Deleted Sucessfully";
	}

	@Override
	public Recipes viewRecipes(int recId) {
		// TODO Auto-generated method stub
		return iRecipesDao.findById(recId).get();
	}
}
