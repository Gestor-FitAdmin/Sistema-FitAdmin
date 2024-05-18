package org.example.Modelo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Enum.EObjetivo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


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

    public void crearUnaRutina(Cliente cliente)
    {

        switch(objetivo.ordinal())
        {
            case 1: //perder peso
                //generarRutina(objetivo,cliente);
                break;
            case 2://ganar fuerza

                break;
            case 3://ganar musculo

                break;
            default:

                break;

        }


    }

    public double calcularPromedioCliente(Cliente cliente)//funcion clave
    {
        //Calculamos el promedio para poder luego generar una rutina adecuada al cliente.

        double promedio = 0;// el promedio va a ser entre 0 y 1;
        double pesoCliente = cliente.getPeso();
        double altura = cliente.getAltura();
        //rea
        String sexo = cliente.getSexo();
        //segun el genero
        if(sexo.equalsIgnoreCase("Masculino"))
        {
            promedio += 0.25;
            if((pesoCliente>=40 && pesoCliente<50))
            {
                promedio += 0.15;
            }
            else if(pesoCliente>=50 && pesoCliente<60)
            {
                promedio += 0.2;
            }
            else if(pesoCliente>=60 && pesoCliente<80)
            {
                promedio += 0.35;
            }else if(pesoCliente>=80)
            {
                promedio += 0.4;
            }
        }else if(sexo.equalsIgnoreCase("Femenino"))
        {
            promedio += 0.15;
        }
        //segun el peso


        return promedio;
    }



    /* public Rutina generarRutina(EObjetivo objetivo,Cliente cliente)
     {
         Rutina rutinaGenerada;
         //si es perder peso, el 80% va a ser de cardio
         if(objetivo.ordinal() == 1)
         {

             /*while(rutina.add <= tope 12series)
             {
                 if(cardio == json cardio && i <8series)
                 {
                     i
                 }
                  random != cardio
             }
         }

         return rutinaGenerada;
     }*/
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
