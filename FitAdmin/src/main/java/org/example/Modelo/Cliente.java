package org.example.Modelo;

import org.example.Enum.EDiasSemana;

import java.util.*;

public class Cliente extends Persona{

    //Metodos
    private int idSocio;
    private String eMail;
    private boolean cuotaPagada;
    private boolean estado;
    private LinkedHashMap<String, Rutina> rutinaSemanal;
    private HashSet<String> actividadesInscripto;

    //Constructor

    public Cliente(String nombre, String apellido, String DNI, String sexo, Double peso, Double altura, String fechaDeNacimiento, int idSocio, String eMail, boolean cuotaPagada) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idSocio = idSocio;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = true; //cuando se crea el cliente el estado siempre es true

        rutinaSemanal = new LinkedHashMap<>();
        actividadesInscripto = new HashSet<>();
    }


    //Getters y Setters

    public int getIdSocio() {
        return idSocio;
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
            msj +="Numero de socio: "+ cliente.getIdSocio()+"\n";
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
                "idSocio=" + idSocio +
                ", eMail='" + eMail + '\'' +
                ", cuotaPagada=" + cuotaPagada +
                ", estado=" + estado +
                ", rutinaSemanal=" + rutinaSemanal +
                ", actividadesInscripto=" + actividadesInscripto +
                '}' + super.toString();
    }
}



