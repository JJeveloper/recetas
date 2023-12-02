package com.gastronomia.recetas.controller;

import com.gastronomia.recetas.entity.RecetaEntity;
import com.gastronomia.recetas.service.RecetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    RecetasService recetasService;

    @PostMapping("/create")
    public ResponseEntity<RecetaEntity> createReceta(@RequestBody RecetaEntity newResponseEntity){
        try {
            RecetaEntity receta = recetasService.createReceta(newResponseEntity);
            return new ResponseEntity<>(receta, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<RecetaEntity>> findAllRecetas(){
        try {
            List<RecetaEntity> receta = recetasService.findAllRecetas();
            return new ResponseEntity<>(receta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findreceta/{id}")
    public ResponseEntity<?> findReceta(@PathVariable Integer id){
        try {
            Optional<RecetaEntity> receta = recetasService.findByIdReceta(id);
            return new ResponseEntity<>(receta, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RecetaEntity> updateReceta(@PathVariable("id") Integer id, @RequestBody RecetaEntity recetaUpdate){

        try {
            Optional<RecetaEntity> rec = recetasService.findByIdReceta(id);
            if (rec.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            RecetaEntity receta = recetasService.updateReceta(id, recetaUpdate);
            return new ResponseEntity<>(receta, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReceta(@PathVariable("id") Integer id){
        try {
            Optional<RecetaEntity> receta = recetasService.findByIdReceta(id);
            if (receta.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            recetasService.deleteReceta(id);
            return ResponseEntity.badRequest().body("La receta se elimino correctamente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
