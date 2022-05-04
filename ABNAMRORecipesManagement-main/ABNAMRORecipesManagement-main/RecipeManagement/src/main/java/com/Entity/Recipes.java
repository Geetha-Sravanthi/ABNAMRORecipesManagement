package com.Entity;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@Entity
@Table(name="Recipes")
public class Recipes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipes_id")
	private int id;
	
	private String name;
	@JsonFormat(pattern="dd‐MM‐yyyy HH:mm", shape=Shape.STRING)
	private  LocalDateTime localdatetime;
	private boolean vegetarian;
	private int servings;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipes_id")
	private List<Ingredients> ingredients;
	private  String instructions;
	
	
	public Recipes() {
		super();
	}
	

	public Recipes(int id, String name, LocalDateTime localdatetime, boolean vegetarian, int servings,
			List<Ingredients> ingredients, String instructions) {
		super();
		this.id = id;
		this.name = name;
		this.localdatetime = localdatetime;
		this.vegetarian = vegetarian;
		this.servings = servings;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDateTime getLocaldatetime() {
		return localdatetime;
	}


	public void setLocaldatetime(LocalDateTime localdatetime) {
		this.localdatetime = localdatetime;
	}


	public boolean isVegetarian() {
		return vegetarian;
	}


	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}


	public int getServings() {
		return servings;
	}


	public void setServings(int servings) {
		this.servings = servings;
	}


	public List<Ingredients> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}


	public String getInstructions() {
		return instructions;
	}


	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


	@Override
	public String toString() {
		return "Recipes [id=" + id + ", name=" + name + ", localdatetime=" + localdatetime + ", vegetarian="
				+ vegetarian + ", servings=" + servings + ", ingredients=" + ingredients + ", instructions="
				+ instructions + "]";
	}
	
	}
	
	