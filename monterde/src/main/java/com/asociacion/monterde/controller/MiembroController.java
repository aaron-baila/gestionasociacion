package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    @GetMapping
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros/lista";
    }

    @GetMapping("/{id}")
    public String verMiembro(@PathVariable Long id, Model model) {
        miembroService.obtenerMiembroPorId(id).ifPresent(miembro -> model.addAttribute("miembro", miembro));
        return "miembros/detalle";
    }

    @GetMapping("/nuevo")
    public String crearMiembroForm(Model model) {
        model.addAttribute("miembro", new Miembro());
        return "miembros/form";
    }

    @PostMapping("/nuevo")
    public String crearMiembro(@ModelAttribute Miembro miembro) {
        miembroService.crearMiembro(miembro);
        return "redirect:/miembros";
    }


    @PostMapping("/{id}/eliminar")
    public String eliminarMiembro(@PathVariable Long id) {
        miembroService.eliminarMiembro(id);
        return "redirect:/miembros";
    }
}
