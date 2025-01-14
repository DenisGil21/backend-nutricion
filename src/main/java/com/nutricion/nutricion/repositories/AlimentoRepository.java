package com.nutricion.nutricion.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nutricion.nutricion.entities.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
    Page<Alimento> findByOrderByIdAsc(Pageable pageable);

    List<Alimento> findByGrupoId(Long id);
}
