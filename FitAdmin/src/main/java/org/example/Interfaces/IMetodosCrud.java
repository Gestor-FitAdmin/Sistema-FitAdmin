package org.example.Interfaces;

public interface IMetodosCrud<E>
{

    //cambiar nombre de interface a metodos CRUD o similar

    boolean agregar(E e);
    boolean archivar(E e);
    E buscar(Integer i);
    String listar();
}
