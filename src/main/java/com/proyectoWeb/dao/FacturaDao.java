package com.proyectoWeb.dao;


import com.proyectoWeb.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
// Nos va a permitir hacer los select, delete, insert y create de manera automatica
public interface FacturaDao 
        extends JpaRepository<Factura, Long>
{

}
