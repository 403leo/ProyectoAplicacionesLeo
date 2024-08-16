/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWeb.dao;

import com.proyectoWeb.domain.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository<Producto,Long>{

    
}
