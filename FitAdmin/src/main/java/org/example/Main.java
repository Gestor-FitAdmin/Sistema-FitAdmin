package org.example;

import org.example.Enum.EObjetivo;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Rutina;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Rutina rutina = new Rutina(EObjetivo.PERDER_PESO,3);

       ArrayList<Ejercicio> ejercicios =  rutina.leerJSONEjercicio("ejercicios.json");
        System.out.println(ejercicios);

      
      // rutina.generarRutinaDelDia("C:\\Users\\Gc\\Desktop\\programacion\\tpFinal3erCuatri\\FitAdmin\\src\\main\\resources\\ejercicios.json",EObjetivo.PERDER_PESO,20);
       // System.out.println(rutina);
    }
}
      
