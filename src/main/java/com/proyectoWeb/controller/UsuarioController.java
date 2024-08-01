package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Usuario;
import com.proyectoWeb.service.TarjetaService;
import com.proyectoWeb.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private TarjetaService tarjetaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        
        
        return "usuario/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/registrarse";
    }
    
       @GetMapping("/inicioSesion")
    public String inicioSesion(Model model){ 
        return "usuario/inicioSesion";
    }
    
    @GetMapping("/cuenta")
    public String cuenta(Model model){
        
        return "usuario/cuenta";
    }
    
    @GetMapping("/registrarse")
    public String registrarse(Model model){ 
        return "usuario/registrarse";
    }
    @GetMapping("/index")
    public String index(Model model){ 
        return "index";
    }

}
