package org.example.Modelo;

import org.example.Enum.EDiasSemana;

import java.util.*;

public class Cliente extends Persona{

    //Metodos
    private int idCliente;
    private String eMail;
    private boolean cuotaPagada;
    private boolean estado;
    private LinkedHashMap<String, Rutina> rutinaSemanal;
    private HashSet<String> actividadesInscripto;

    //Constructor


    //cliente con id
    public Cliente(String nombre, String apellido, String DNI, String sexo, Double peso, Double altura, String fechaDeNacimiento, String eMail, boolean cuotaPagada) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idCliente = 0;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = true; //cuando se crea el cliente el estado siempre es true

        rutinaSemanal = new LinkedHashMap<>();
        actividadesInscripto = new HashSet<>();
    }

    //Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isCuotaPagada() {
        return cuotaPagada;
    }

    public boolean isEstado() {
        return estado;
    }


    public HashMap<String, Rutina> getRutinaSemanal() {
        return rutinaSemanal;
    }

    public HashSet<String> getActividadesInscripto() {
        return actividadesInscripto;
    }

    public void agregarActividadACliente(String actividadesInscripto) {
        this.actividadesInscripto.add(actividadesInscripto);
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    //Metodos
    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if(!super.equals(o))
        {
            if(o != null)
            {
                if(o instanceof Cliente aComparar)
                {
                    if(this.getDNI().equals(aComparar.getDNI()))
                    {
                        rta = true;
                    }

                }

            }

        }

       return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public void asignarUnaRutinaAUnDia(Rutina nuevaRutina, EDiasSemana diaAsignado){
        String stringDiaAsignado = diaAsignado.name(); //obtengo el valor del enum pero en formato String (lo parseo a un string)

        rutinaSemanal.put(stringDiaAsignado,nuevaRutina);
    }
    //Esta funcion me va a servir para ordenar por dias y luego imprimir el PDF correctamente
    public String formatearDatosCliente(Cliente cliente)
    {
        String msj = "";
        if(cliente!= null)
        {
            msj +="Numero de socio: "+ cliente.getIdCliente()+"\n";
            msj +="Nombre: "+ cliente.getNombre()+"\n";
            msj +="Apellido: "+ cliente.getApellido()+"\n";
            msj +="DNI: "+ cliente.getDNI()+"\n";
            msj +="E-Mail: "+ cliente.geteMail()+"\n";
            msj +="Sexo: "+ cliente.getSexo()+"\n";
            msj +="Edad: "+ cliente.getEdad()+"\n";
            msj +="Fecha de nacimiento: "+ cliente.getFechaDeNacimiento()+"\n";
            msj +="Peso: "+ cliente.getPeso()+"\n";
            msj +="Altura: "+ cliente.getAltura()+"\n";
            msj +="Actividades en las que se encuentra inscripto: "+ cliente.getActividadesInscripto()+"\n";
        }

        return msj;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "idSocio=" + idCliente +
                ", eMail='" + eMail + '\'' +
                ", cuotaPagada=" + cuotaPagada +
                ", estado=" + estado +
                ", rutinaSemanal=" + rutinaSemanal +
                ", actividadesInscripto=" + actividadesInscripto +
                '}' + super.toString();
    }
    public String listarActidades()//metodo para que no tener corchetes en la GUI
    {
        String msj ="";
            Iterator iterator = actividadesInscripto.iterator();
            while(iterator.hasNext())
            {
                msj+= iterator.next();
            }

        return msj;
    }
}



