package com.asociacion.monterde.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

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

    @Column(nullable = false, length = 50) // Campo obligatorio, máximo 50 caracteres
    private String nombre;

    @Column(nullable = false, unique = true, length = 100) // Campo obligatorio y único
    private String email;

    @Column(nullable = false, length = 15) // Campo obligatorio, máximo 15 caracteres
    private String telefono;

    @Enumerated(EnumType.STRING) // Almacenar como texto en la base de datos
    //@Column(nullable = false) // Campo obligatorio
    private Rol rol;

    /**
     * Método equals personalizado, asegurando la comparación basada en el ID.
     * Maneja casos en los que Hibernate usa proxies para entidades perezosamente cargadas.
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true; // Comparar referencias
        if (o == null) return false;

        // Manejar proxys de Hibernate para obtener las clases reales
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();

        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();

        if (thisEffectiveClass != oEffectiveClass) return false;

        Miembro miembro = (Miembro) o;
        return getId() != null && Objects.equals(getId(), miembro.getId());
    }

    /**
     * Método hashCode personalizado, compatible con equals.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}
