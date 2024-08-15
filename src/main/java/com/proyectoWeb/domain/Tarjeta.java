/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWeb.domain;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tarjeta")

public class Tarjeta {

    // Este atributo es para representar el auto incremento de los id
    private static final long serialVersionUID = 1L;

    // Este @id hace que el siguiente atributo de la linea siguiente
    // es el id de llave primaria. 
    @Id
    // Decir que tome que de manera igual a la base de datos,
    // Es decir que se va copiar el auto incremento de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    // En objetos hay mayusculas y en las bases de datos minusculas.
    private Long idTarjeta;
    private String numeroTarjeta;
    private String nombreTitular;
    private int digitosAtras;
    private String vencimientoTarjeta;

    // Incorporar la logica para muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
