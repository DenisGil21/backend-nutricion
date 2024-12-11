package com.nutricion.nutricion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int verdura;

    private int fruta;

    private int cereal;

    private int leguminosa;

    private int leche;

    private int proteina;

    private int grasa;

    @ManyToOne
    @JoinColumn(name = "tiempo_id", nullable = false)
    private Tiempo tiempo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
