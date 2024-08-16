
package com.proyectoWeb.service;

import com.proyectoWeb.domain.Producto;
import java.util.List;


public interface ProductoService {
    public List<Producto>getProductos();
    
    public Producto getProducto(Producto producto);
    
    //Producto getProductoById(Long idProducto);

}
