package org.example.Modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Cliente extends Persona{

    //Metodos
    private int idSocio;
    private String eMail;
    boolean cuotaPagada;
    boolean estado;
    private HashMap<String, Rutina> rutinaSemanal;
    private HashSet<Actividad> actividadesInscripto;

    //Constructor

    public Cliente(String nombre, String apellido, String DNI, String sexo, Double peso, Double altura, Date fechaDeNacimiento, int idSocio, String eMail, boolean cuotaPagada, boolean estado) {
        super(nombre, apellido, DNI, sexo, peso, altura, fechaDeNacimiento);
        this.idSocio = idSocio;
        this.eMail = eMail;
        this.cuotaPagada = cuotaPagada;
        this.estado = estado;

        rutinaSemanal = new HashMap<>();
        actividadesInscripto = new HashSet<>();
    }


    //Getters y Setters


    //Metodos

    
}
