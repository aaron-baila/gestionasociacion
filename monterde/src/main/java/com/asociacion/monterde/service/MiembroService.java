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
     * @return El Miembro recién creado.
     */
    Miembro crearMiembro(Miembro miembro);

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
     * Actualiza un miembro existente.
     *
     * @param id      ID del miembro a actualizar.
     * @param miembro Objeto Miembro con los datos actualizados.
     * @return Miembro actualizado.
     */
    Miembro actualizarMiembro(Long id, Miembro miembro);

    /**
     * Verifica si un miembro existe por su ID.
     *
     * @param id ID del miembro.
     * @return true si el miembro existe, false en caso contrario.
     */
    boolean existeMiembro(Long id);

    /**
     * Obtiene una lista de todos los miembros activos.
     *
     * @return Lista de miembros activos.
     */
    List<Miembro> obtenerListaMiembrosActivos();

    /**
     * Inactiva un miembro en lugar de eliminarlo permanentemente.
     *
     * @param id ID del miembro a inactivar.
     */
    void inactivarMiembro(Long id);
}
