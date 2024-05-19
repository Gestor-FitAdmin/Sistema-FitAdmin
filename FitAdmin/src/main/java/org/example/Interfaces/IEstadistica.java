package org.example.Interfaces;

public interface IEstadistica
{
   int  contarTotalClientes();
   String listarClientesActivos();
   String listarClientesInactivos();
   String listarClientesXGenero(String genero);
   String listarClientesEnXActividad(String actividad);
   double recaudacionTotal();
}
