package com.asociacion.monterde.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String cif;

    @Column(length = 20, nullable = false)
    private String tipo = "otro";

}
