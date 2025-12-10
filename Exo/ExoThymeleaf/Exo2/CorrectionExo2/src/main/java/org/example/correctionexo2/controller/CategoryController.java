package org.example.correctionexo2.controller;


import org.example.correctionexo2.entity.Category;
import org.example.correctionexo2.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public String add (Model model){
        model.addAttribute("category",new Category());
        return "categoryForm";
    }

    @PostMapping
    public String addCategory (Category category){
        service.create(category);
        return "redirect:/";
    }
}
