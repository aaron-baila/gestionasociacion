package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

<<<<<<< Updated upstream
=======
    @Operation(summary = "Listar todos los miembros activos")
    @GetMapping
    public String listarMiembros(Model model) {
        List<Miembro> miembrosActivos = miembroService.obtenerListaMiembrosActivos().orElse(List.of());
        model.addAttribute("miembros", miembrosActivos);

        if (miembrosActivos.isEmpty()) {
            model.addAttribute("mensaje", "No hay miembros activos.");
        }

        return "miembros/miembros";
    }

    @Operation(summary = "Mostrar formulario vacio")
    @GetMapping("/formulario")
    public String formulario() {
        return "miembros/formulario-miembro";
    }

    @Operation(summary = "Crear un nuevo miembro")
>>>>>>> Stashed changes
    @PostMapping("/formulario")
    public String crearMiembro(@ModelAttribute @Valid Miembro miembro, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Por favor corrige los errores en el formulario.");
            return "miembros/formulario-miembro";
        }
        try {
            miembro.setFechaIngreso(LocalDate.now());
            miembroService.crearMiembro(miembro);
            model.addAttribute("success", "Miembro creado con éxito."); // Mensaje de éxito
            return "redirect:/miembros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el miembro. Inténtalo de nuevo.");
            return "miembros/formulario-miembro";
        }
    }

<<<<<<< Updated upstream


    // Listar todos los miembros
    @GetMapping
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros/miembros";
    }
=======
>>>>>>> Stashed changes

    // Mostrar formulario vacío para agregar un nuevo miembro
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("miembro", new Miembro());
        return "miembros/formulario-miembro"; // Nombre del template Thymeleaf
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id, @RequestParam(required = false) String redirect) {
        if (miembroService.existeMiembro(id)) {
            miembroService.eliminarMiembro(id); // Llama al servicio para eliminar al miembro

            if ("true".equals(redirect)) {
<<<<<<< Updated upstream
                // Si el parámetro 'redirect' está presente, redirige a la lista de miembros
                return "redirect:/miembros";
=======
                return "redirect:/miembros/miembros";
>>>>>>> Stashed changes
            }
        }
        return "redirect:/miembros?error=notfound"; // Redirige si no se encuentra el miembro
    }


<<<<<<< Updated upstream
    // Mostrar formulario prellenado para editar un miembro existente
=======
    @Operation(summary = "Mostrar el formulario para editar un miembro")
>>>>>>> Stashed changes
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Miembro> miembro = miembroService.obtenerMiembroPorId(id);
        if (miembro.isPresent()) {
            model.addAttribute("miembro", miembro.get());
            return "miembros/formulario-miembro"; // Vista para editar miembro
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
