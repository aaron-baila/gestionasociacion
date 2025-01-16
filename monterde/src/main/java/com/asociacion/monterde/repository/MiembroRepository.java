package com.asociacion.monterde.repository;

import com.asociacion.monterde.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Long> {
    String id(Long id);
}
