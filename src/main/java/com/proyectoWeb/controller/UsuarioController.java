package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Tarjeta;
import com.proyectoWeb.domain.Usuario;
import com.proyectoWeb.service.FireBaseStorageService;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private FireBaseStorageService firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        // Obtén el usuario por su nombre de usuario
        Usuario usuario = usuarioService.findByUsername(username);
        
        // Obtén las tarjetas asociadas al usuario
        List<Tarjeta> tarjetas = tarjetaService.findByUsuario(usuario);

        model.addAttribute("tarjetas", tarjetas);
        return "usuario/listado";
    }
    
//    @GetMapping("/usuario/perfil")
//    public String perfilUsuario(Authentication authentication, Model model) {
//        // Obtén el nombre de usuario del usuario autenticado
//        String username = authentication.getName();
//
//        // Obtén el usuario por su nombre de usuario
//        Usuario usuario = usuarioService.findByUsername(username);
//
//        // Obtén las tarjetas asociadas al usuario
//        List<Tarjeta> tarjetas = tarjetaService.findByUsuario(usuario);
//
//        // Agrega los datos al modelo
//        model.addAttribute("usuario", usuario);
//        model.addAttribute("tarjetas", tarjetas);
//
//        return "usuario/perfil";
//    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        var codigo = new BCryptPasswordEncoder();
        usuario.setContrasena(codigo.encode(usuario.getContrasena()));
        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getIdUsuario()));
        }

        usuarioService.save(usuario);
        return "redirect:/usuario/registrarse";
    }

    @GetMapping("/inicioSesion")
    public String inicioSesion(Model model) {
        return "usuario/inicioSesion";
    }

    @GetMapping("/cuenta")
    public String cuenta(Model model) {

        return "usuario/cuenta";
    }

    @GetMapping("/registrarse")
    public String registrarse(Model model) {
        return "usuario/registrarse";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar( Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        // Obtén el usuario por su nombre de usuario
        Usuario usuario = usuarioService.findByUsername(username);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificar";
    }
}
