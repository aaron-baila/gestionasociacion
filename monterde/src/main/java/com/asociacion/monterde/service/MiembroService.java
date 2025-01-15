package com.asociacion.monterde.service;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.repository.MiembroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroService {

    private final MiembroRepository miembroRepository;

    public MiembroService(MiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    public List<Miembro> obtenerTodosLosMiembros() {
        return miembroRepository.findAll();
    }

    public Optional<Miembro> obtenerMiembroPorId(Long id) {
        return miembroRepository.findById(id);
    }

    public Miembro crearMiembro(Miembro miembro) {
        return miembroRepository.save(miembro);
    }



    public void eliminarMiembro(Long id) {
        miembroRepository.deleteById(id);
    }
}
