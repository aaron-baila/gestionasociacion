package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    // Método para listar los miembros en la vista
    @GetMapping("/miembros")
    public String listarMiembros(Model model) {
        // Obtiene la lista de miembros desde el servicio
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros"; // Nombre de la vista de Thymeleaf
    }
}
