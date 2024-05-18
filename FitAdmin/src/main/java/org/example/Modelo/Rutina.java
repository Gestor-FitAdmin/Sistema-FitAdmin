package org.example.Modelo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Enum.EObjetivo;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Rutina
{
    //atributos
    private LinkedHashSet<Ejercicio> rutina;//nos importa el orden de realizacion de ejercicios
    private EObjetivo objetivo; //Perder peso|Ganar fuerza|Ganar musculo
    private int cantidadDeDias;//dias de entrenamiento
    //constructores

    public Rutina(EObjetivo objetivo, int cantidadDeDias) {
        this.objetivo = objetivo;
        this.cantidadDeDias = cantidadDeDias;
        rutina = new LinkedHashSet<>();
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
    private ArrayList instanciarJSONaArrayList(String archivo)
    {
        ArrayList<Ejercicio> ejerciciosJSON;
        try {
            ejerciciosJSON = leerJSONEjercicio(archivo);//obtengo todos los ejercicios del sistema
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Random rand = new Random();
        for(int i = 0 ;i<ejerciciosJSON.size();i++)
        {
            ejerciciosJSON.get(i).setSeries(rand.nextInt(4 - 3 + 1) + 3);
            ejerciciosJSON.get(i).setRepeticiones(rand.nextInt(15 - 6 + 1) + 6);
        }

        return ejerciciosJSON;
    }
    private double calcularIMC(double peso,double altura)///18.5 y 24.9 se considera normal
    {
        return peso/Math.pow(altura,2); //me sirve para ver la dificultad de la rutina
    }

    public void generarRutinaDelDia(String archivo,EObjetivo objetivo,int cantMaximaDeSeries)//HAY QUE AGREGAR CLIENTES PARA CALCULAR LA DIFICULTAD CON EL PESO Y DEMAS ATRIBUTOS IMC(YA ESTA HECHA LA FUNCION HAY QUE IMPLEMENTARLA)
     {
         //Ejemplo cantMaximaDeSeries maximo de series|| tope maximo por ejemplo prensa = 4 series + sentadilla 4 series + peso muerto 4 series + bici 4 series + bco plano 4 series = 20

         int contadorSeries = 0;//me va a contar cuantas series voy acumulando del JSON
         int i = 0;

         ArrayList <Ejercicio> ejerciciosJSON = instanciarJSONaArrayList(archivo);
         //si es perder peso, el 70% va a ser de cardio
         if(objetivo.equals(EObjetivo.PERDER_PESO))//perder peso
         {
                 while(i<ejerciciosJSON.size())//si recorri el json y termino, espero a que el contador se llene porque necesito la rutina entera
                 {
                             if((ejerciciosJSON.get(i).getTipoDeEjercicio().equalsIgnoreCase("cardio")) && (calcularPorcentaje(cantMaximaDeSeries,contadorSeries)< 0.65))//65%
                             {
                                 rutina.add(ejerciciosJSON.get(i));
                                 contadorSeries += ejerciciosJSON.get(i).getSeries();

                             }

                     i++;
                 }
                 i = 0;
                 while(contadorSeries<cantMaximaDeSeries)//Si pasa el 65% le pongo otro ejercicio distinto a cardio y si es menor 1.1 por el margen de error que tienen las series
                 {

                        if(calcularPorcentaje(cantMaximaDeSeries,contadorSeries)>=0.65 && calcularPorcentaje(cantMaximaDeSeries,contadorSeries)<1)
                        {
                         Random rand = new Random();
                         int numeroAleatorio = rand.nextInt(ejerciciosJSON.size());//creo un random para que la rutina de 0 a el tamaño de ejercicios que tenga el JSON

                            Ejercicio e = ejerciciosJSON.get(numeroAleatorio);

                         if(!e.getNombreEjercicio().equalsIgnoreCase("Cardio"))
                         {
                             rutina.add(e);
                             contadorSeries+= e.getSeries();
                         }

                    }
                 }

         }


     }
    private int calcularFrecuenciaDelTipoDeEjercicio(String tipoEjercicio) {
        int frecuencia = 0;
        for (Ejercicio ejercicio : rutina) {
            if (ejercicio.getTipoDeEjercicio().equalsIgnoreCase(tipoEjercicio)) {
                frecuencia++;
            }
        }
        return frecuencia;
    }
     private double calcularPorcentaje(int cantidadDeSeriesMaximas,int cantidadActual)
     {
         return (double) cantidadActual/cantidadDeSeriesMaximas;
     }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rutina rutina1 = (Rutina) o;
        return cantidadDeDias == rutina1.cantidadDeDias && Objects.equals(rutina, rutina1.rutina) && objetivo == rutina1.objetivo;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "rutina=" + rutina +
                ", objetivo=" + objetivo +
                ", cantidadDeDias=" + cantidadDeDias +
                '}';
    }
}
