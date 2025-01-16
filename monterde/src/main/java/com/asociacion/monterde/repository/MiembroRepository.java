package com.asociacion.monterde.repository;

import com.asociacion.monterde.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, String> {
    // Aquí podemos agregar más consultas personalizadas si es necesario
}
