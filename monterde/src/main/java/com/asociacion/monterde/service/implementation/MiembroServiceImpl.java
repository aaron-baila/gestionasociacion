package com.asociacion.monterde.service.implementation;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.repository.MiembroRepository;
import com.asociacion.monterde.service.MiembroService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroServiceImpl implements MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public List<Miembro> obtenerTodosLosMiembros() {
        return miembroRepository.findAll();
    }

    public void crearMiembro(Miembro miembro) {
        miembroRepository.save(miembro);
    }

    public void eliminarMiembro(Long idMiembro) {
        miembroRepository.deleteById(idMiembro);
    }

    public Optional<Miembro> obtenerMiembroPorId(Long id) {
        return miembroRepository.findById(id);
    }

    @Transactional
    public void actualizarMiembro(Long id, Miembro miembroActualizado) {
        // Buscar el miembro en la base de datos
        Optional<Miembro> miembroOptional = miembroRepository.findById(id);

        // Si el miembro existe
        if (miembroOptional.isPresent()) {
            Miembro miembroExistente = miembroOptional.get();
            miembroActualizado.setId(miembroExistente.getId());

            // Copiar todas las propiedades de miembroActualizado a miembroExistente
            BeanUtils.copyProperties(miembroActualizado, miembroExistente);
            // Guardar el miembro actualizado en la base de datos
            miembroRepository.save(miembroExistente);
        } else {
            // Si el miembro no se encuentra, lanzar una excepción o manejar el error
            throw new EntityNotFoundException("Miembro con ID " + id + " no encontrado.");
        }
    }


    @Override
    public boolean existeMiembro(Long id) {
        return miembroRepository.existsById(id);
    }

    @Override
    public Optional<List> obtenerListaMiembrosActivos() {
        return Optional.ofNullable(miembroRepository.findByEstado(Miembro.Estado.ACTIVO));
    }


}
