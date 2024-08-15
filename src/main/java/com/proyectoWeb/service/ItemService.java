package com.proyectoWeb.service;

import com.proyectoWeb.domain.Item;
import java.util.List;

public interface ItemService {

    //Se usa para tener en una session de memoria la información del carrito de compras
    public List<Item> gets();

    //Se recupera el registro que tiene el idItem pasado por parámetro
    //si no existe en la tabla se retorna null
    public Item get(Item item);

    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Item item);

    //Si el objeto item tiene un idItem que existe en el ArrayList item
    //El registro de actualiza con la cantidad + 1
    //Si el idItem NO existe en la tabla, se crea el registro con esa información con la cantidad en 1
    public void save(Item item);

    public void update(Item item);

    public void facturar();

    public double getTotal();
}
