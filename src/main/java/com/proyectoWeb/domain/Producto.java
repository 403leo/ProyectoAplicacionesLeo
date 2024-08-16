/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWeb.domain;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="producto")
public class Producto {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
