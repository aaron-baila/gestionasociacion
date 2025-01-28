package com.asociacion.monterde.service;

import com.asociacion.monterde.model.Miembro;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para gestionar las operaciones relacionadas con los miembros.
 */
public interface MiembroService {

    /**
     * Obtiene una lista de todos los miembros.
     *
     * @return Lista de objetos Miembro.
     */
    List<Miembro> obtenerTodosLosMiembros();

    /**
     * Crea un nuevo miembro.
     *
     * @param miembro Objeto Miembro a crear.
     */
    void crearMiembro(Miembro miembro);

    /**
     * Elimina un miembro por su ID.
     *
     * @param idMiembro ID del miembro a eliminar.
     */
    void eliminarMiembro(Long idMiembro);

    /**
     * Obtiene un miembro específico por su ID.
     *
     * @param id ID del miembro a buscar.
     * @return Objeto Optional que puede contener el Miembro encontrado.
     */
    Optional<Miembro> obtenerMiembroPorId(Long id);

    /**
     * Actualiza la información de un miembro existente.
     *
     * @param id
     * @param miembro Objeto Miembro con la información actualizada.
     */
    void actualizarMiembro(Long id, Miembro miembro);

    boolean existeMiembro(Long id);

    List obtenerListaMiembrosActivos();
}
