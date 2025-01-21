package com.asociacion.monterde.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento para el ID
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Lob
    private String ubicacion;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('','benéfico','formativo','otro') DEFAULT 'otro'")
    private TipoEvento tipo = TipoEvento.otro;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('pendiente','en curso','finalizado') DEFAULT 'pendiente'")
    private EstadoEvento estado = EstadoEvento.pendiente;

    @Column(precision = 10, scale = 2)
    private BigDecimal presupuesto;

    // Enum para el tipo de evento
    public enum TipoEvento {
        benéfico, // Correcto
        social,
        cultural,
        otro, formativo
    }

    // Enum para el estado del evento
    public enum EstadoEvento {
        pendiente,
        en_curso,
        finalizado
    }
}
