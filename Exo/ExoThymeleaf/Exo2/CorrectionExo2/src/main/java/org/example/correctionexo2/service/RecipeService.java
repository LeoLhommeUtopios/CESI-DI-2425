package org.example.correctionexo2.service;

import org.example.correctionexo2.entity.Recipe;
import org.example.correctionexo2.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe create (Recipe recipe){
        recipe.setId(UUID.randomUUID());
        repository.save(recipe);
        return recipe;
    }

    public Recipe get(UUID id){
        return repository.findById(id).orElse(null);
    }

    public List<Recipe> get (){
        return repository.findAll();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }

    public Recipe update(Recipe recipe){
        if(get(recipe.getId()) !=null){
            repository.save(recipe);
        }
        return recipe;
    }
}
