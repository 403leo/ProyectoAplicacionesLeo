// Todos estos paquetes como dao, domain o service 
// es para poder ordenar el sql 

package com.proyectoWeb.service;

import com.proyectoWeb.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
    // Se recupera la lista de usuarios 
    //de la tabla usuario dentro de un arrayList
    // Solo las activas o todas...
    public List<Usuario> getUsuarios();
    
    
    // Se obtiene un registro de usuarios en un 
    // objeto de tipo usuario
    // Si el idUsuario existe si no existe es nulo.
    public Usuario getusuario(Usuario usuario);
    
    // Se crea un nuevo registro en la tabla usuario,
    // si el obbjeto Usuario NO tiene idUsuario
    // Se actualiza el regitro en la tabla usuario,
    // Si el objeto Usuario tiene un idUsuario  
    public void save(Usuario usuario);
    
    // Se elimina el registro en la tabla usuario si 
    // el idUsuario existe en la tabla
    public void delete(Usuario usuario);
    

    
}
