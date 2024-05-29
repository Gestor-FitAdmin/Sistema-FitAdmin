package org.example.Interfaces;

import org.example.Enum.ESexo;

public interface IEstadistica
{
   int  contarTotalClientes();
   int contarClientesActivos();
   int contarClientesInactivos();
   int contarClientesXGenero(ESexo sexoBuscado);
   int contarClientesXActividad(String actividad);
   double recaudacionTotal();
}
