package org.example.Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Gimnasio
{
    //atributos
    private String nombre;
    private String direccion;
    private HashMap<Integer,Cliente> clientes;//INTEGER = GetIdSocio
    private String usuario;
    private String contrasenia;
    private ArrayList<Actividad> actividades;
    //constructores

    public Gimnasio(String nombre, String direccion, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;

        clientes = new HashMap<>();
        actividades = new ArrayList<>();
    }

    //getters y setters

    //metodos

}
