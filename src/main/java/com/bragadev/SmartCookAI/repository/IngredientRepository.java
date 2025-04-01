package com.bragadev.SmartCookAI.repository;

import com.bragadev.SmartCookAI.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository <Ingredient, Long> {
}

