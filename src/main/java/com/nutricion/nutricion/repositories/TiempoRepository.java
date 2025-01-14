package com.nutricion.nutricion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutricion.nutricion.entities.Tiempo;

public interface TiempoRepository extends JpaRepository<Tiempo, Long>{
    
}
