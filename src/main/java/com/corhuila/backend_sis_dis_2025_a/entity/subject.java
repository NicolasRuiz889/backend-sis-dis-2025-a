package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data

public class subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;

    private String codigo;
}