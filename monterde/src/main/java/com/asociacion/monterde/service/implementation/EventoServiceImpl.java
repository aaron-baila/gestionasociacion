package com.asociacion.monterde.service.implementation;

import com.asociacion.monterde.model.Evento;
import com.asociacion.monterde.repository.EventoRepository;
import com.asociacion.monterde.service.EventoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    public void crearEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public void eliminarEvento(Long idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    public Optional<Evento> obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    @Transactional
    public void actualizarEvento(Long id, Evento eventoActualizado) {
        // Buscar el evento en la base de datos
        Optional<Evento> eventoOptional = eventoRepository.findById(id);

        // Si el evento existe
        if (eventoOptional.isPresent()) {
            Evento eventoExistente = eventoOptional.get();
            eventoActualizado.setId(eventoExistente.getId());

            // Copiar todas las propiedades de eventoActualizado a eventoExistente
            BeanUtils.copyProperties(eventoActualizado, eventoExistente);
            // Guardar el evento actualizado en la base de datos
            eventoRepository.save(eventoExistente);
        } else {
            // Si el evento no se encuentra, lanzar una excepción o manejar el error
            throw new EntityNotFoundException("Evento con ID " + id + " no encontrado.");
        }
    }


    @Override
    public boolean existeEvento(Long id) {
        return eventoRepository.existsById(id);
    }
}
