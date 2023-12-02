package com.gastronomia.recetas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredientes")
public class IngredientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreingrediente;

    @ManyToMany(mappedBy = "ingredientesEntities")
    @JsonIgnore
    private List<RecetaEntity> recetaEntities;

    public IngredientesEntity() {
    }

    public IngredientesEntity(Integer id, String nombreingrediente, List<RecetaEntity> recetaEntities) {
        this.id = id;
        this.nombreingrediente = nombreingrediente;
        this.recetaEntities = recetaEntities;
    }

    public IngredientesEntity(String nombreingrediente) {
        this.nombreingrediente = nombreingrediente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreingrediente() {
        return nombreingrediente;
    }

    public void setNombreingrediente(String nombreingrediente) {
        this.nombreingrediente = nombreingrediente;
    }

    public List<RecetaEntity> getRecetaEntities() {
        return recetaEntities;
    }

    public void setRecetaEntities(List<RecetaEntity> recetaEntities) {
        this.recetaEntities = recetaEntities;
    }
}
