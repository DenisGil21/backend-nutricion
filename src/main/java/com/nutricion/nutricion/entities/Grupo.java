package com.nutricion.nutricion.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alimentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private int caloriasPorciones;

    private int proteina;

    private int grasa;

    private int carbohidrato;
    
    private int cont_carbo;

    @OneToMany(mappedBy = "grupo")
    private List<Alimento> alimentos;

}
