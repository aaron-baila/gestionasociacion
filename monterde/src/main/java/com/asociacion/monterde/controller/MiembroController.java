package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Tag(name = "Miembros", description = "Gestión de los miembros de la asociación")
@Controller
@RequestMapping("/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    @Operation(summary = "Crear un nuevo miembro")
    @PostMapping("/formulario")
    public String crearMiembro(@ModelAttribute @Valid Miembro miembro, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Por favor corrige los errores en el formulario.");
            return "miembros/formulario-miembro";
        }
        try {
            miembro.setFechaIngreso(LocalDate.now());
            miembroService.crearMiembro(miembro);
            model.addAttribute("success", "Miembro creado con éxito.");
            return "redirect:/miembros";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el miembro. Inténtalo de nuevo.");
            return "miembros/formulario-miembro";
        }
    }

    @Operation(summary = "Listar todos los miembros activos")
    @GetMapping
    public String listarMiembros(Model model) {
        List miembrosActivos = miembroService.obtenerListaMiembrosActivos();
        if (miembrosActivos.isEmpty()) {
            model.addAttribute("error", "No se encontraron los miembros activos.");
        } else {
            model.addAttribute("miembros", miembrosActivos);
        }
        //TODO: mirar de si poner optional
//        if (miembrosActivos.isPresent()) {
//            model.addAttribute("miembros", miembrosActivos);
//        } else {
//            model.addAttribute("mensaje", "No hay miembros activos.");
//        }

        return "miembros/miembros";
    }
//TODO: poner bien los mapping no ponner get poner delete o post
//    este metodo elimina de verdad pero de momento solo pondremos en inactivo
//    @Operation(summary = "Eliminar un miembro por ID")
//    @GetMapping("/eliminar/{id}")
//    public String eliminarMiembro(@PathVariable Long id, @RequestParam(required = false) String redirect) {
//        if (miembroService.existeMiembro(id)) {
//            miembroService.eliminarMiembro(id);
//
//            if ("true".equals(redirect)) {
//                return "redirect:/miembros";
//            }
//        }
//        return "redirect:/miembros?error=notfound";
//    }

    @Operation(summary = "Eliminar un miembro por ID")
    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id, @RequestParam(required = false) String redirect) {
        if (miembroService.existeMiembro(id)) {
            miembroService.inactivarMiembro(id);

            if ("true".equals(redirect)) {
                return "redirect:/miembros";
            }
        }
        return "redirect:/miembros?error=notfound";
    }

    @Operation(summary = "Mostrar el formulario para editar un miembro")
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Miembro> miembro = miembroService.obtenerMiembroPorId(id);
        if (miembro.isPresent()) {
            model.addAttribute("miembro", miembro.get());
            return "miembros/formulario-miembro";
        } else {
            return "redirect:/miembros?error=notfound";
        }
    }

    @Operation(summary = "Editar un miembro existente")
    @PostMapping("/formulario/{id}")
    private String editarMiembro(@PathVariable Long id, @ModelAttribute @Valid Miembro miembroActualizado, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Por favor corrige los errores en el formulario.");
            return "miembros/formulario-miembro";
        }

        if (miembroService.existeMiembro(id)) {
            miembroService.actualizarMiembro(id, miembroActualizado);
            return "redirect:/miembros";
        } else {
            model.addAttribute("error", "El miembro no existe.");
            return "miembros/formulario-miembro";
        }
    }
}
