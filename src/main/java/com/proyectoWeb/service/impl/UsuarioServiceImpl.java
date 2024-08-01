package com.proyectoWeb.service.impl;

import com.proyectoWeb.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoWeb.dao.UsuarioDao;
import com.proyectoWeb.service.UsuarioService;

@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private UsuarioDao usuarioDao;

    
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getUsuarios() {
        var lista = usuarioDao.findAll();

        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getusuario(Usuario usuario) {
        // Esta logica encuentra el usuario pero si no lo hace devuelve nulo en el .orElse
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }


}
