package com.asociacion.monterde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index() {
        return "index"; // Thymeleaf buscará src/main/resources/templates/index.html
    }
}
