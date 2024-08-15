package com.proyectoWeb.service.impl;

import com.proyectoWeb.dao.UsuarioDao;
import com.proyectoWeb.domain.Usuario;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoWeb.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Autowired HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //Buscar al usuario en la tabla
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if (usuario==null) {
            throw new UsernameNotFoundException(username);
        }
        
        // Si llegamos aqui es por que todo bien
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        
        
        //Devolver el usuario UserDetails
        return new User(usuario.getUsername(),usuario.getContrasena(), Collections.emptyList());
    }

}
