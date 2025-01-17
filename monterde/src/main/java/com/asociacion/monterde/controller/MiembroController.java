package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @GetMapping
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros";
    }

    //    @DeleteMapping("/eliminar/{id}")
    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id) {
        miembroService.eliminarMiembro(id); // Llama al servicio
        return "redirect:/miembros"; // Redirige tras eliminar
    }

    @GetMapping("/actualizar/{id}")
    public String editarMiembro(@PathVariable Long id, Model model) {
        miembroService.actualizarMiembro((Miembro) model);
        Miembro miembroActualizado = (Miembro) model;
        return "miembro"; // Redirige tras eliminar
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("miembro", new Miembro());
        return "formulario-miembro"; // Nombre del template Thymeleaf
    }

    @PostMapping("/formulario")
    public String agregarMiembro(@ModelAttribute Miembro miembro) {
        miembroService.crearMiembro(miembro); // Guarda el miembro en la base de datos
        return "redirect:/miembros"; // Redirige a la lista de miembros después de guardar
    }
//    public String guardarMiembro(Miembro miembro) {}
}
