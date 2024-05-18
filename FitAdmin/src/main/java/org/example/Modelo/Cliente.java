package org.example.Modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Cliente extends Persona{

    //Metodos
    private int idSocio;
    private String eMail;
    private boolean cuotaPagada;
    private boolean estado;
    private HashMap<String, Rutina> rutinaSemanal;
    private HashSet<Actividad> actividadesInscripto;

    //Constructor

    public Cliente(String nombre, String apellido, String DNI, String sexo, Double peso, Double altura, String fechaDeNacimiento, int idSocio, String eMail, boolean cuotaPagada) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idSocio = idSocio;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = true; //cuando se crea el cliente el estado siempre es true

        rutinaSemanal = new HashMap<>();
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

    public HashSet<Actividad> getActividadesInscripto() {
        return actividadesInscripto;
    }

    public void setActividadesInscripto(HashSet<Actividad> actividadesInscripto) {
        this.actividadesInscripto = actividadesInscripto;
    }

    public void setRutinaSemanal(HashMap<String, Rutina> rutinaSemanal) {
        this.rutinaSemanal = rutinaSemanal;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    //Metodos

    
}
