// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.proyectoWeb.service;

import com.proyectoWeb.domain.Tarjeta;
import com.proyectoWeb.domain.Usuario;
import java.util.List;

public interface TarjetaService {
    
    // Se recupera la lista de tarjetas 
    //de la tabla tarjeta dentro de un arrayList
    // Solo las activas o todas...
    public List<Tarjeta> getTarjetas();
    
    
    // Se obtiene un registro de tarjetas en un 
    // objeto de tipo tarjeta
    // Si el idTarjeta existe si no existe es nulo.
    public Tarjeta gettarjeta(Tarjeta tarjeta);
    
    // Se crea un nuevo registro en la tabla tarjeta,
    // si el obbjeto Tarjeta NO tiene idTarjeta
    // Se actualiza el regitro en la tabla tarjeta,
    // Si el objeto Tarjeta tiene un idTarjeta  
    public void save(Tarjeta tarjeta);
    
    // Se elimina el registro en la tabla tarjeta si 
    // el idTarjeta existe en la tabla
    public void delete(Tarjeta tarjeta);
    
    
    List<Tarjeta> findByUsuario(Usuario usuario);
    
}
