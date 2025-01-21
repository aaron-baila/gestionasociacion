package com.asociacion.monterde.service;

import com.asociacion.monterde.model.Evento;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para gestionar las operaciones relacionadas con los eventos.
 */
public interface EventoService {

    /**
     * Obtiene una lista de todos los eventos.
     *
     * @return Lista de objetos Evento.
     */
    List<Evento> obtenerTodosLosEventos();

    /**
     * Crea un nuevo evento.
     *
     * @param evento Objeto Evento a crear.
     */
    void crearEvento(Evento evento);

    /**
     * Elimina un evento por su ID.
     *
     * @param idEvento ID del evento a eliminar.
     */
    void eliminarEvento(Long idEvento);

    /**
     * Obtiene un evento específico por su ID.
     *
     * @param id ID del evento a buscar.
     * @return Objeto Optional que puede contener el Evento encontrado.
     */
    Optional<Evento> obtenerEventoPorId(Long id);

    /**
     * Actualiza la información de un evento existente.
     *
     * @param id
     * @param evento Objeto Evento con la información actualizada.
     */
    void actualizarEvento(Long id, Evento evento);

    boolean existeEvento(Long id);
}
