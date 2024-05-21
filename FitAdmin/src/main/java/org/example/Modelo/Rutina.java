package org.example.Modelo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Enum.EObjetivo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Rutina
{
    //atributos
    private LinkedHashSet<Ejercicio> rutina;//nos importa el orden de realizacion de ejercicios
    private EObjetivo objetivo; //Perder peso|Ganar fuerza|Ganar musculo
    //dias de entrenamiento
    //constructores

    public Rutina(EObjetivo objetivo) {
        this.objetivo = objetivo;
        rutina = new LinkedHashSet<>();
    }

    //getters y setters

    public LinkedHashSet<Ejercicio> getRutina() {
        return rutina;
    }

    public EObjetivo getObjetivo()
    {
        return objetivo;
    }

    public void setObjetivo(EObjetivo objetivo)
    {
        this.objetivo = objetivo;
    }

    //metodos

    public boolean agregarUnEjercicioARutina(Ejercicio nuevoEjercicio)
    {
        //al ser un LinkedHashSet, el ejercicio no se repetiria y tiene orden
        return rutina.add(nuevoEjercicio);
    }

    public boolean sacarUnEjercicioDeRutinaXObjeto(Ejercicio ejercicioAEliminar)
    {
        return rutina.remove(ejercicioAEliminar);
    }

//    public boolean agregarUnEjercicioARutinaXId(int idEjercicioAAgregar, int repeticiones, int series){
//        boolean flag=false;
//        Iterator<Ejercicio> iterator = rutina.iterator();
//        while (iterator.hasNext() && flag==false)
//        {
//            Ejercicio ejercicioAux=iterator.next();
//            if (ejercicioAux.getIdEjercicio() == idEjercicioAAgregar)
//            {
//                ejercicioAux.setRepeticiones(repeticiones);
//                ejercicioAux.setSeries(series);
//                rutina.add(ejercicioAux);
//                flag=true;
//            }
//
//        }
//        return flag;
//    }

    public boolean agregarUnEjercicioARutinaXID(int idEjercicioAAgregar, int repeticiones, int series){
        boolean flag = false;
            ArrayList<Ejercicio> ejercicios;

            try {
                ejercicios = leerJSON("ejercicios.json");

                for (Ejercicio ejercicio : ejercicios) {
                    if (ejercicio.getIdEjercicio() == idEjercicioAAgregar) {
                        ejercicio.setSeries(series);
                        ejercicio.setRepeticiones(repeticiones);
                        rutina.add(ejercicio);
                        flag = true;
                    }
                }
            }
            catch (IOException e){
                e.getMessage();
                e.printStackTrace();
            }

        return flag;
    }

    public boolean sacarUnEjercicioDeRutinaXId(int idEjercicioAEliminar)
    {
        boolean flag=false;
        Iterator<Ejercicio> iterator = rutina.iterator();
        while (iterator.hasNext() && flag==false)
        {
            Ejercicio ejercicioAux=iterator.next();
            if (ejercicioAux.getIdEjercicio() == idEjercicioAEliminar)
            {
                rutina.remove(ejercicioAux);
                flag=true;
            }

        }
        return flag;
    }






    //funcion para leer el JSON de un ejerciciod
    public ArrayList<Ejercicio> leerJSON(String archivo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(); // Clase para serializar y deserializar datos de JSON
        ArrayList<Ejercicio> ejercicioArrayList;

        //Intentar leer un archivo desde el ClassPath
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivo)) {
            if (inputStream == null) {
                throw new IOException("Archivo no encontrado: " + archivo);
            }

            //Carga el ArrayList con los datos del JSON
            ejercicioArrayList = objectMapper.readValue(inputStream, new TypeReference<ArrayList<Ejercicio>>() {
            });
        } catch (IOException e){
            throw e;
        }

        return  ejercicioArrayList;
    }



    @Override
    public boolean equals(Object o) {
        boolean flag=false;
        if (o != null)
        {
            if (o instanceof Rutina rutinaAComparar)
            {
                if (this.rutina.equals(rutinaAComparar.rutina) && this.objetivo == rutinaAComparar.objetivo )
                {
                    flag=true;
                }
            }
        }
        return flag;
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
                '}';
    }
}
