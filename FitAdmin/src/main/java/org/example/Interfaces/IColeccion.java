package org.example.Interfaces;

public interface IColeccion <E>
{
    boolean agregar(E e);
    boolean archivar(E e);
    E buscar(Integer i);
}
