package com.gastronomia.recetas.controller;

import com.gastronomia.recetas.entity.IngredientesEntity;
import com.gastronomia.recetas.entity.RecetaEntity;
import com.gastronomia.recetas.service.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredientesController {

    @Autowired
    IngredientesService ingredientesService;

    @PostMapping("/create")
    public ResponseEntity<IngredientesEntity> createIngrediente(@RequestBody IngredientesEntity newIngredientesEntity) {
        try {
            IngredientesEntity ingredientes = ingredientesService.createIngredientes(newIngredientesEntity);
            return new ResponseEntity<>(ingredientes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<IngredientesEntity>> findAllIngredientes(){
        try {
            List<IngredientesEntity> ingredientes = ingredientesService.findAllIngredientes();
            return new ResponseEntity<>(ingredientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findingrediente/{id}")
    public ResponseEntity<?> findIngredienteById(@PathVariable Integer id){

        try {
            Optional<IngredientesEntity> ingre = ingredientesService.findByIdIngredientes(id);
            return new ResponseEntity<>(ingre, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IngredientesEntity> updateIngrediente(@PathVariable("id") Integer id, @RequestBody IngredientesEntity ingredientesUpdate){

        try {
            Optional<IngredientesEntity> ingre = ingredientesService.findByIdIngredientes(id);
            if (ingre.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            IngredientesEntity ingredientes = ingredientesService.updateIngredientes(id, ingredientesUpdate);
            return new ResponseEntity<>(ingredientes, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIngrediente(@PathVariable("id") Integer id){
        try {
            Optional<IngredientesEntity> ingre = ingredientesService.findByIdIngredientes(id);
            if (ingre.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            ingredientesService.deleteIngredientes(id);
            return ResponseEntity.badRequest().body("El trabajador se elimino correctamente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
