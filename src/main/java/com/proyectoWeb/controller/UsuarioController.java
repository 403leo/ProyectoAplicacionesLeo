package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Tarjeta;
import com.proyectoWeb.domain.Usuario;
import com.proyectoWeb.service.FireBaseStorageService;
import com.proyectoWeb.service.TarjetaService;
import com.proyectoWeb.service.UsuarioService;
import jakarta.mail.MessagingException;
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
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        // Verifica que 'usuario' no sea null antes de añadirlo al modelo
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }

        List<Tarjeta> tarjetas = tarjetaService.findByUsuario(usuario);
        model.addAttribute("tarjetas", tarjetas);
        return "usuario/listado";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getIdUsuario()));
        }
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
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

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getusuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }

}
