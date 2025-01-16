package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @GetMapping("/miembros")
    public String listarMiembros(Model model) {
        model.addAttribute("miembros", miembroService.obtenerTodosLosMiembros());
        return "miembros";
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMiembro(@PathVariable Long id) {
        miembroService.eliminarMiembro(id); // Llama al servicio para eliminar
        return ResponseEntity.ok().build(); // Responde con un estado 200 OK
    }
}
