package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //TODO:    @DeleteMapping("/eliminar/{id}") habra que investigar como hacerlo
    @GetMapping("/eliminar/{id}")
    public String eliminarMiembro(@PathVariable Long id) {
        miembroService.eliminarMiembro(id); // Llama al servicio
        return "redirect:/miembros"; // Redirige tras eliminar
    }


    @GetMapping("/nuevo")
    public String agregarMiembro() {
        return "nuevomiembro";
    }
//    @GetMapping("/nuevo")
//    public String agregarMiembro(Miembro miembro) {
//        miembroService.crearMiembro(miembro);
//        return "nuevomiembro";
//    }
}
