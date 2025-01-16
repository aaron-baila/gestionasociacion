package com.asociacion.monterde.service.implementation;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.repository.MiembroRepository;
import com.asociacion.monterde.service.MiembroService;
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
    public void actualizarMiembro(Miembro miembro) {
        miembroRepository.save(miembro);
    }
}
