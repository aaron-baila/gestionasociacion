package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Evento;
import com.asociacion.monterde.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    // Inyección de dependencias mediante constructor
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping("/formulario")
    public String crearEvento(@ModelAttribute @Valid Evento evento, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Por favor corrige los errores en el formulario.");
            return "formulario-evento";
        }
        try {
            eventoService.crearEvento(evento);
            return "redirect:/eventos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el evento. Inténtalo de nuevo.");
            return "formulario-evento";
        }
    }


    // Listar todos los eventos
    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoService.obtenerTodosLosEventos());
        return "eventos/eventos";
    }

    // Mostrar formulario vacío para agregar un nuevo evento
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario-evento"; // Nombre del template Thymeleaf
    }

    // Eliminar un evento por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        if (eventoService.existeEvento(id)) {
            eventoService.eliminarEvento(id); // Llama al servicio
            return "redirect:/eventos"; // Redirige tras eliminar
        } else {
            return "redirect:/eventos?error=notfound"; // Redirige si el evento no existe
        }
    }

    // Mostrar formulario prellenado para editar un evento existente
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Evento> evento = eventoService.obtenerEventoPorId(id);
        if (evento.isPresent()) {
            model.addAttribute("evento", evento.get());
            return "eventos/formulario-evento"; // Vista para editar evento
        } else {
            return "redirect:/eventos?error=notfound"; // Redirige si no se encuentra el evento
        }
    }

    // Editar un evento existente
    @PostMapping("/formulario/{id}")
    public String editarEvento(@PathVariable Long id, @ModelAttribute Evento eventoActualizado, Model model) {
        if (eventoService.existeEvento(id)) {
            eventoService.actualizarEvento(id, eventoActualizado);
            return "redirect:/eventos"; // Redirección tras la actualización
        } else {
            model.addAttribute("error", "El evento no existe.");
            return "formulario-evento"; // Redirige al formulario con el mensaje de error
        }
    }
}
