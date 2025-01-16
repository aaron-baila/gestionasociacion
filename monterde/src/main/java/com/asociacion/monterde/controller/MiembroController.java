package com.asociacion.monterde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiembroController {
    @GetMapping("/miembros")
    public String miembros() {
        return "miembros"; // Thymeleaf buscará src/main/resources/templates/index.html
    }
}
