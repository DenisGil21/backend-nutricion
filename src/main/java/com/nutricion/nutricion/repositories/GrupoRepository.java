package com.nutricion.nutricion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutricion.nutricion.entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
