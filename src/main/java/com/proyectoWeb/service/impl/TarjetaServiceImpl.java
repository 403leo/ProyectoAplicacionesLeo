package com.proyectoWeb.service.impl;

import com.proyectoWeb.domain.Tarjeta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoWeb.dao.TarjetaDao;
import com.proyectoWeb.domain.Usuario;
import com.proyectoWeb.service.TarjetaService;

@Service
public class TarjetaServiceImpl
        implements TarjetaService {

    // El autowired es para que se cree automaticamente un objeto
    // y solo uno va a existir
    @Autowired
    private TarjetaDao tarjetaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Tarjeta> getTarjetas() {
        var lista = tarjetaDao.findAll();

        return lista;

    }

    @Override
    @Transactional(readOnly = true)
    public Tarjeta gettarjeta(Tarjeta tarjeta) {
        // Esta logica encuentra el tarjeta pero si no lo hace devuelve nulo en el .orElse
        return tarjetaDao.findById(tarjeta.getIdTarjeta()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Tarjeta tarjeta) {
        tarjetaDao.save(tarjeta);
    }

    @Override
    @Transactional
    public void delete(Tarjeta tarjeta) {
        tarjetaDao.delete(tarjeta);
    }
    
    @Override
    public List<Tarjeta> findByUsuario(Usuario usuario) {
        return tarjetaDao.findByUsuario(usuario);
    }

}
