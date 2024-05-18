package org.example.Interfaces;

import org.example.Modelo.Cliente;

public interface IColeccion <E>
{

    //cambiar nombre de interface a metodos CRUD o similar

    boolean agregar(E e);
    boolean archivar(E e);
    E buscar(Integer i);
    String listar();
}
