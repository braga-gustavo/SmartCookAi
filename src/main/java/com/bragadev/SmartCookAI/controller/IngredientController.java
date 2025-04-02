package com.bragadev.SmartCookAI.controller;


import com.bragadev.SmartCookAI.model.Ingredient;
import com.bragadev.SmartCookAI.repository.IngredientRepository;
import com.bragadev.SmartCookAI.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: Connect with AI
@Controller
@RequestMapping("/food")
public class IngredientController {


    @Autowired
    IngredientService service;

    @Autowired
    IngredientRepository repository;

    @PostMapping
    public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = service.save(ingredient);
        return ResponseEntity.ok(savedIngredient);
    }

    @GetMapping
    ResponseEntity<List<Ingredient>> listIngredients(){
        List<Ingredient> list = service.listIngredients();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientToUpdate) {
        return service.findById(id).map(existingIngredient -> {
                    ingredientToUpdate.setId(existingIngredient.getId());
                    Ingredient updatedIngredient = service.update(ingredientToUpdate);
                    return ResponseEntity.ok(updatedIngredient);
                }).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(Long id) {
        repository.deleteById(id);
    }
}
