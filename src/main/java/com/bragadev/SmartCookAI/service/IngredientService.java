package com.bragadev.SmartCookAI.service;

import com.bragadev.SmartCookAI.model.Ingredient;
import com.bragadev.SmartCookAI.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository repository;

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public List<Ingredient> listIngredients() {
        return repository.findAll();
    }

    public Optional<Ingredient> findById(Long id) {
        return repository.findById(id);
    }

    public Ingredient update(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
