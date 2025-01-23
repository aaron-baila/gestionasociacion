package com.asociacion.monterde.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento para el ID
    private Long id;

    @Column(nullable = false, length = 15)
    private String dni;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 50)
    private String apodo;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String telefono;
    @Lob
    private String direccion;
//TODO: mirar bien fecha nacimiento al editar que se quede igual que la que habia
    @Column(nullable = false)
    private LocalDate fechaNacimiento; // Fecha de nacimiento

    @Lob
    private String foto;

    @Column(length = 50)
    private String cargo;

    @Column(nullable = true)
    private LocalDate fechaIngreso;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVO', 'INACTIVO') DEFAULT 'ACTIVO'")
    private Estado estado = Estado.ACTIVO;

    private Boolean LOPD; // LOPD (protección de datos) aceptado

    public enum Estado {
        ACTIVO, INACTIVO
    }

}
