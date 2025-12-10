package org.example.correctionexo2.controller;

import jakarta.websocket.server.PathParam;
import org.example.correctionexo2.entity.Recipe;
import org.example.correctionexo2.service.CategoryService;
import org.example.correctionexo2.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/recipe")
public class recipeController {

    private RecipeService recipeService;
    private CategoryService categoryService;

    public recipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String allRecipe (Model model){
        model.addAttribute("recipes",recipeService.get());
        return "recipe/recipeList";
    }

    @GetMapping("/detail/{id}")
    public String recipeDetail (@PathVariable("id") UUID id,Model model){
        model.addAttribute("recipe",recipeService.get(id));
        return "recipe/detailRecipe";
    }

    @GetMapping("/add")
    public String recipeForm (Model model){
        model.addAttribute("category",categoryService.get());
        model.addAttribute("recipe",new Recipe());
        return "recipe/formRecipe";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe){
        recipeService.create(recipe);
        return "redirect:/recipe";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe (@PathVariable("id") UUID id){
        recipeService.delete(id);
        return "redirect:/recipe";
    }

    @GetMapping("/update/{id}")
    public String updateRecipe (@PathVariable("id") UUID id,Model model){
        model.addAttribute("category",categoryService.get());
        model.addAttribute("recipe",recipeService.get(id));
        return "recipe/formRecipe";
    }

    @PostMapping("/update")
    public String updateRecipe(Recipe recipe){
        recipeService.update(recipe);
        return "redirect:/recipe";
    }
}
