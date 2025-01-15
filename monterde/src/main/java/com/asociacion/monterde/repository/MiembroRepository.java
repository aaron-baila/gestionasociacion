package com.asociacion.monterde.repository;

import com.asociacion.monterde.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}
