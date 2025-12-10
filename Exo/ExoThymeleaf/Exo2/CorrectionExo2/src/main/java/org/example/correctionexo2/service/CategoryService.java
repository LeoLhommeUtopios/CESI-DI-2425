package org.example.correctionexo2.service;

import org.example.correctionexo2.entity.Category;
import org.example.correctionexo2.entity.Recipe;
import org.example.correctionexo2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create (Category category){
        category.setId(UUID.randomUUID());
        repository.save(category);
        return category;
    }

    public Category get(UUID id){
        return repository.findById(id).orElse(null);
    }

    public List<Category> get (){
        return repository.findAll();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }

    public Category update(Category category){
        if(get(category.getId()) !=null){
            repository.save(category);
        }
        return category;
    }
}
