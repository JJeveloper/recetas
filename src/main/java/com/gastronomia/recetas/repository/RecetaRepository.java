package com.gastronomia.recetas.repository;

import com.gastronomia.recetas.entity.RecetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<RecetaEntity,Integer> {
}
