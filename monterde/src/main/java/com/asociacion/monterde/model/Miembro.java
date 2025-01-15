package com.asociacion.monterde.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Miembro {
    @Id
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String rol;

    
    // Getters y setters
}
