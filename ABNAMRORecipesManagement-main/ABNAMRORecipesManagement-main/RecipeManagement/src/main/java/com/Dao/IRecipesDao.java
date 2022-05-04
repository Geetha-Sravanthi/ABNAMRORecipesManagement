package com.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Entity.Recipes;
public interface IRecipesDao extends JpaRepository<Recipes, Integer> {
}
