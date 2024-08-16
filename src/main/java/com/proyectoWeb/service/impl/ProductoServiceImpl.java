
package com.proyectoWeb.service.impl;

import com.proyectoWeb.dao.ProductoDao;
import com.proyectoWeb.domain.Producto;
import com.proyectoWeb.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos() {
        var lista = productoDao.findAll();

        return lista;

    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
//    @Override
//    public Producto getProductoById(Long idProducto) {
//        return productoDao.findById(idProducto).orElse(null);
//    }
//    
    
}
