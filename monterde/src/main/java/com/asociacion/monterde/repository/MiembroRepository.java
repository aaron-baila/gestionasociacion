package com.asociacion.monterde.repository;

import com.asociacion.monterde.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Long> {

    @Transactional
    @Modifying
    @Query("update Miembro m set m.dni = :dni, m.nombre = :nombre, m.apellidos = :apellidos where m.id = :id")
    void updateDniAndNombreAndApellidosById(@Param("dni") String dni, @Param("nombre") String nombre, @Param("apellidos") String apellidos, @Param("id") Long id);

    List<Miembro> findByEstado_Activo();

}
