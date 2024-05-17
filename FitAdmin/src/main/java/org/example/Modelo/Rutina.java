package org.example.Modelo;


import org.example.Enum.EObjetivo;

import java.util.ArrayList;


public class Rutina
{
    //atributos
    private ArrayList<Ejercicio> rutina;//nos importa el orden de realizacion de ejercicios
    private EObjetivo objetivo; //Perder peso|Ganar fuerza|Ganar musculo
    private int cantidadDeDias;//dias de entrenamiento
    //constructores

    public Rutina(EObjetivo objetivo, int cantidadDeDias) {
        this.objetivo = objetivo;
        this.cantidadDeDias = cantidadDeDias;
    }

    //getters y setters

    public EObjetivo getObjetivo()
    {
        return objetivo;
    }

    public void setObjetivo(EObjetivo objetivo)
    {
        this.objetivo = objetivo;
    }

    public int getCantidadDeDias()
    {
        return cantidadDeDias;
    }

    public void setCantidadDeDias(int cantidadDeDias)
    {
        this.cantidadDeDias = cantidadDeDias;
    }

    //metodos


}
