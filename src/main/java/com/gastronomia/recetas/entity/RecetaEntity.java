package com.gastronomia.recetas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recetas")
public class RecetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombrereceta;

    @Column(length = 10000)
    private String preparacion;


    @JoinTable(name = "recetas_ingredientes",
    joinColumns = @JoinColumn(name = "id_receta", nullable = false),
    inverseJoinColumns = @JoinColumn(name= "id_ingrediente",nullable = false))
    @ManyToMany
    private List<IngredientesEntity> ingredientesEntities;

    public RecetaEntity(Integer id, String nombrereceta, String preparacion, List<IngredientesEntity> ingredientesEntities) {
        this.id = id;
        this.nombrereceta = nombrereceta;
        this.preparacion = preparacion;
        this.ingredientesEntities = ingredientesEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrereceta() {
        return nombrereceta;
    }

    public void setNombrereceta(String nombrereceta) {
        this.nombrereceta = nombrereceta;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public List<IngredientesEntity> getIngredientesEntities() {
        return ingredientesEntities;
    }

    public void setIngredientesEntities(List<IngredientesEntity> ingredientesEntities) {
        this.ingredientesEntities = ingredientesEntities;
    }
}
