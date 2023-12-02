package com.gastronomia.recetas.service;

import com.gastronomia.recetas.entity.IngredientesEntity;
import com.gastronomia.recetas.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientesService {

    @Autowired
    IngredientesRepository ingredientesRepository;

    public IngredientesEntity createIngredientes(IngredientesEntity ingredientesEntity){
       try {
           return ingredientesRepository.save(ingredientesEntity);
       }catch (Exception e){
           throw new RuntimeException("Error al crear un ingrediente " + e.getMessage());
       }
    }

    public List<IngredientesEntity> findAllIngredientes(){
        try {
            return ingredientesRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al obtener los ingrediente" + e.getMessage());
        }
    }

    public Optional<IngredientesEntity> findByIdIngredientes(Integer id){
        try {
            return ingredientesRepository.findById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al obtener el ingrediente" + e.getMessage());
        }
    }

    public IngredientesEntity updateIngredientes(Integer id, IngredientesEntity ingredientesEntity){
        try {
            ingredientesEntity.setId(id);
            return ingredientesRepository.save(ingredientesEntity);
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el ingrediente" + e.getMessage());
        }
    }

    public void deleteIngredientes(Integer id){
        try {
            ingredientesRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar los datos" + e.getMessage());
        }
    }



}
