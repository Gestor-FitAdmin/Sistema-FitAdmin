package org.example.Interfaces;

public interface IEstadistica
{
   int  contarTotalClientes();
   int contarClientesActivos();
   int contarClientesInactivos();
   int contarClientesXGenero(String genero);
   int contarClientesXActividad(String actividad);
   double recaudacionTotal();
}
