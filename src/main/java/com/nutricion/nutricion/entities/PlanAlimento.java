package com.nutricion.nutricion.entities;

import java.sql.Date;

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
@Table(name = "planes_alimentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date fecha;

    @ManyToOne()
    @JoinColumn(name="plan_id", nullable=false)
    private Plan plan;

    @ManyToOne()
    @JoinColumn(name="alimento_id", nullable=false)
    private Alimento alimento;

}
