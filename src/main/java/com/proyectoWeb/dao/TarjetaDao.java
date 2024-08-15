package com.proyectoWeb.dao;

import com.proyectoWeb.domain.Tarjeta;
import com.proyectoWeb.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// Nos va a permitir hacer los select, delete, insert y create de manera automatica
public interface TarjetaDao 
        extends JpaRepository<Tarjeta, Long>
{
    // Otros métodos ya existentes...

    List<Tarjeta> findByUsuario(Usuario usuario);
}
