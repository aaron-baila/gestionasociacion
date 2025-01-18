package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    // Inyección de dependencias mediante constructor
    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    // Crear un nuevo miembro
    @PostMapping("/formulario")
    public String agregarMiembro(@ModelAttribute Miembro miembro, Model model) {
        try {
            miembro.setFechaIngreso(LocalDate.now());
            miembroService.crearMiembro(miembro); // Guarda el miembro en la base de datos
            return "redirect:/miembros"; // Redirige a la lista de miembros después de guardar
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el miembro. Inténtalo de nuevo.");
            return "formulario-miembro";
        }
    }

    // Listar todos los miembros
    @GetMapping
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros";
    }

    // Mostrar formulario vacío para agregar un nuevo miembro
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("miembro", new Miembro());
        return "formulario-miembro"; // Nombre del template Thymeleaf
    }

    // Eliminar un miembro por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id) {
        if (miembroService.existeMiembro(id)) {
            miembroService.eliminarMiembro(id); // Llama al servicio
            return "redirect:/miembros"; // Redirige tras eliminar
        } else {
            return "redirect:/miembros?error=notfound"; // Redirige si el miembro no existe
        }
    }

    // Mostrar formulario prellenado para editar un miembro existente
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Miembro> miembro = miembroService.obtenerMiembroPorId(id);
        if (miembro.isPresent()) {
            model.addAttribute("miembro", miembro.get());
            return "formulario-miembro"; // Vista para editar miembro
        } else {
            return "redirect:/miembros?error=notfound"; // Redirige si no se encuentra el miembro
        }
    }

    // Editar un miembro existente
    @PostMapping("/formulario/{id}")
    public String editarMiembro(@PathVariable Long id, @ModelAttribute Miembro miembroActualizado, Model model) {
        if (miembroService.existeMiembro(id)) {
            miembroService.actualizarMiembro(id, miembroActualizado);
            return "redirect:/miembros"; // Redirección tras la actualización
        } else {
            model.addAttribute("error", "El miembro no existe.");
            return "formulario-miembro"; // Redirige al formulario con el mensaje de error
        }
    }
}
