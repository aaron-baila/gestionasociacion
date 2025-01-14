package com.asociacion.monterde.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monterde")
public class MiControlador {
    @GetMapping("/saludo")
    public String saludo() {
        return "¡Hola desde la asociación cultural!";
    }
}
