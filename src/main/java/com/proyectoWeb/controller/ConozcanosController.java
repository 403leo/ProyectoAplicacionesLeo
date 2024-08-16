package com.proyectoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

// Esta clase mapea el la clase html de listado. 
@Controller
@RequestMapping("/conozcanos")
public class ConozcanosController {

    // Mapea la ruta que se quiera utilizar
    @GetMapping("/listado")
    public String listado(Model model) {

        return "/conozcanos/listado";
    }

}
