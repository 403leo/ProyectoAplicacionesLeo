package com.proyectoWeb.service.impl;

import com.proyectoWeb.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoWeb.dao.UsuarioDao;
import com.proyectoWeb.service.CorreoService;
import com.proyectoWeb.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...
    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;


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
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYContrasena(String username, String contrasena) {
        return usuarioDao.findByUsernameAndContrasena(username, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsername(String username) {
        return usuarioDao.existsByUsername(username);
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
