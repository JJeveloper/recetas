package com.gastronomia.recetas.service;

import com.gastronomia.recetas.entity.IngredientesEntity;
import com.gastronomia.recetas.entity.RecetaEntity;
import com.gastronomia.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetasService {

    @Autowired
    RecetaRepository recetaRepository;

    public RecetaEntity createReceta(RecetaEntity recetaEntity){
        try {
            return recetaRepository.save(recetaEntity);
        }catch (Exception e){
            throw new RuntimeException("Error al crear una receta " + e.getMessage());
        }
    }

    public List<RecetaEntity> findAllRecetas(){
        try {
            return recetaRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error al obtener las receta" + e.getMessage());
        }
    }

    public Optional<RecetaEntity> findByIdReceta(Integer id){
        try {
            return recetaRepository.findById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al obtener la receta" + e.getMessage());
        }
    }

    public RecetaEntity updateReceta(Integer id, RecetaEntity recetaEntity ){
        try {
            recetaEntity.setId(id);
            return recetaRepository.save(recetaEntity);
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar la receta" + e.getMessage());
        }
    }

    public void deleteReceta(Integer id){
        try {
            recetaRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar la receta" + e.getMessage());
        }
    }

}
