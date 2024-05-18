package org.example.Modelo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Enum.EObjetivo;

import java.io.File;
import java.io.IOException;
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


    public ArrayList<Ejercicio> leerJSONEjercicio(String archivo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Ejercicio> ejercicioArrayList = new ArrayList<>();
        try{
            File fichero = new File(archivo);
            ejercicioArrayList = objectMapper.readValue(fichero, new TypeReference<ArrayList<Ejercicio>>() {});
        }
        catch (IOException e){
            throw e;
        }

        return  ejercicioArrayList;
    }




}
