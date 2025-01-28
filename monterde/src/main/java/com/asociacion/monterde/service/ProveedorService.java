package com.asociacion.monterde.service;

import com.asociacion.monterde.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    List<Proveedor> listarTodos();
    Proveedor guardar(Proveedor proveedor);
    Optional<Proveedor> obtenerPorId(Long id);
    void eliminar(Long id);
    Proveedor buscarPorCif(String cif);
}
