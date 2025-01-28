package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Proveedor;
import com.asociacion.monterde.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Listar todos los proveedores
    @GetMapping
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.listarTodos();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/proveedor"; // Renderiza el archivo templates/proveedor/lista.html
    }

    // Mostrar formulario para crear un nuevo proveedor
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/formulario"; // Renderiza el archivo templates/proveedor/formulario.html
    }

    // Guardar un nuevo proveedor o actualizar uno existente
    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        proveedorService.guardar(proveedor);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor guardado con éxito.");
        return "redirect:/proveedor"; // Redirige a la lista de proveedores
    }

    // Mostrar formulario para editar un proveedor existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Proveedor> proveedorOpt = proveedorService.obtenerPorId(id);
        if (proveedorOpt.isPresent()) {
            model.addAttribute("proveedor", proveedorOpt.get());
            return "proveedor/formulario"; // Reutiliza el mismo formulario para editar
        } else {
            redirectAttributes.addFlashAttribute("error", "Proveedor no encontrado.");
            return "redirect:/proveedor";
        }
    }

    // Eliminar un proveedor
    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        proveedorService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor eliminado con éxito.");
        return "redirect:/proveedor";
    }
}
