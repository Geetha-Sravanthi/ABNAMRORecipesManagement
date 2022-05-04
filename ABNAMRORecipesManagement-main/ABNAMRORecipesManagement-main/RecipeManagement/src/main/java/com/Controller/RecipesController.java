package com.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Entity.Recipes;
import com.Service.IRecipesService;

@RestController
public class RecipesController {
	@Autowired
	IRecipesService iRecipesService;
	@PostMapping(value="/createRecipes")
	public ResponseEntity<String> createRecipes(@RequestBody Recipes rec) {
		return new ResponseEntity<String>( iRecipesService.createRecipes(rec),HttpStatus.OK);
	}
	@PutMapping(value="/updateRecipe/{id}")
	public ResponseEntity<Recipes> updateRecipe(@RequestBody Recipes rec,@PathVariable int id) throws Exception {

	try {
	return new ResponseEntity<Recipes>( iRecipesService.updateRecipes(rec,id),HttpStatus.OK);
	}
	catch(Exception e) {
	throw new Exception("We can't edit Recipe");
	}
	}
	@GetMapping("/fetchAllRecipes")
	public ResponseEntity<List<Recipes>> fetchAllRecipes(){
	return new ResponseEntity<List<Recipes>>(iRecipesService.getall(),HttpStatus.OK);
	}
	@GetMapping(value="/fetchRecipes/{recId}")
	public ResponseEntity<Recipes> viewRecipes(@PathVariable int recId) {
	return new ResponseEntity<Recipes>( iRecipesService.viewRecipes(recId),HttpStatus.OK);
	}
	@DeleteMapping("/deleteRecipeById/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) throws Exception{
	try {
	iRecipesService.deleteById(id);
	return new ResponseEntity<HttpStatus>( HttpStatus.OK);
	}
	catch(Exception e) {
	//return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	throw new Exception("No id is found");
	}
	}	
}
