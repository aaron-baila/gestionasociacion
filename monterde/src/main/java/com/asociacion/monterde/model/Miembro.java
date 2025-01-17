package com.asociacion.monterde.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private String dni; // DNI del miembro

    @Column(nullable = false, length = 100)
    private String nombre; // Nombre del miembro

    @Column(length = 100)
    private String apellidos; // Apellidos del miembro

    @Column(length = 50)
    private String apodo; // Apodo del miembro

    @Column(length = 100)
    private String email; // Correo electrónico

    @Column(length = 15)
    private String telefono; // Teléfono de contacto

    @Lob
    private String direccion; // Dirección

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento; // Fecha de nacimiento

    @Lob
    private String foto; // Foto del miembro

    @Column(length = 50)
    private String cargo; // Cargo del miembro

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso; // Fecha de ingreso

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('activo','inactivo') DEFAULT 'activo'")
    private Estado estado = Estado.ACTIVO; // Estado (activo o inactivo)

    private Boolean LOPD; // LOPD (protección de datos) aceptado

    // Enum para el estado
    public enum Estado {
        ACTIVO, INACTIVO
    }
}
