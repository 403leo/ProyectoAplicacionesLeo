package com.proyectoWeb.dao;

import com.proyectoWeb.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
// Nos va a permitir hacer los select, delete, insert y create de manera automatica
public interface UsuarioDao 
        extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    
    public Usuario findByUsernameAndContrasena(String username, String Contrasena);

}
