// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.proyectoWeb.service;

import com.proyectoWeb.domain.Usuario;
import jakarta.mail.MessagingException;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface UsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario getusuario(Usuario usuario);
    
    
    // Nuevo método para encontrar un usuario por su nombre de usuario
    public Usuario getUsuarioPorUsername(String username);
    
     // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameYContrasena(String username, String contrasena);

    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsername(String username);
    

    public void save(Usuario usuario);
  
    public void delete(Usuario usuario);
    
    
}
