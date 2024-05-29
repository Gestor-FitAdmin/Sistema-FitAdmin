package org.example.Interfaces;

public interface IMetodosCrud<E>
{
    boolean agregar(E e);
    boolean archivar(E e);
    E buscar(Integer i);
    String listar();
}
