package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @PostMapping("/formulario")
    public String agregarMiembro(@ModelAttribute Miembro miembro) {
        miembro.setFechaIngreso(LocalDate.now());
        miembroService.crearMiembro(miembro); // Guarda el miembro en la base de datos
        return "redirect:/miembros"; // Redirige a la lista de miembros después de guardar
    }

    @GetMapping
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("miembro", new Miembro());
        return "formulario-miembro"; // Nombre del template Thymeleaf
    }

    // TODO:   @DeleteMapping("/eliminar/{id}")
    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id) {
        miembroService.eliminarMiembro(id); // Llama al servicio
        return "redirect:/miembros"; // Redirige tras eliminar
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Miembro> miembro = miembroService.obtenerMiembroPorId(id);
        if (miembro.isEmpty()) {
            return "redirect:/miembros?error=notfound";
        }
        model.addAttribute("miembro", miembro.get());
        return "formulario-miembro";  // Vista para editar miembro
    }

    @PostMapping("/editar/{id}")
    public String editarMiembro(@PathVariable Long id, @ModelAttribute Miembro miembroActualizado, Model model) {
        miembroService.actualizarMiembro(id, miembroActualizado);
        return "miembros";  // Redirección tras la actualización
    }

//    @GetMapping("/actualizar/{id}")
//    public String editarMiembro(@PathVariable Long id, Model model) {
//        miembroService.actualizarMiembro((Miembro) model);
//        Miembro miembroActualizado = (Miembro) model;
//        return "miembro"; // Redirige tras eliminar
//    }



//    public String guardarMiembro(Miembro miembro) {}
}
