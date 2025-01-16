package com.asociacion.monterde.service;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    // Método para obtener todos los miembros
    public List<Miembro> obtenerTodosLosMiembros() {
        return miembroRepository.findAll();
    }
}
