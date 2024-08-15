package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Tarjeta;
import com.proyectoWeb.domain.Usuario;
import com.proyectoWeb.service.FireBaseStorageService;
import com.proyectoWeb.service.TarjetaService;
import com.proyectoWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private UsuarioService usuarioService;

    // Mapea la ruta que se quiera utilizar
    @GetMapping("/listado")
    public String listado(Model model) {

        var lista = tarjetaService.getTarjetas();
        model.addAttribute("tarjetas", lista);
        model.addAttribute("totalTarjetas", lista.size());
        // Puedo pasar informacion al html listado
        // Este busca un paquete tarjeta con un html listado en OTHER SOURCES del codigo

        // Para poder mmostrar las categorias en productos se debe agegar el listado de categorias. 
        var categorias = usuarioService.getUsuarios();
        model.addAttribute("usuarios", categorias);
        return "/tarjeta/listado";
    }
    // para poder crear una unica copia del metodo
    @Autowired
    private FireBaseStorageService firebaseStorageService;

    // Metodo para agregar una nueva tarjeta
    @PostMapping("/guardar")
    public String guardar(Tarjeta tarjeta) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Usuario usuario = usuarioService.findByUsername(username);

        // Asignar el usuario autenticado a la tarjeta
        tarjeta.setUsuario(usuario);

        // Guardar la tarjeta
        tarjetaService.save(tarjeta);

        // Vata y ejecute el metodo listado de esta misma clase
        return "redirect:/tarjeta/listado";

    }

}
