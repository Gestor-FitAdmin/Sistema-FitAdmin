package org.example;

import org.example.Enum.ESexo;
import org.example.GUI.*;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Main {
   public static  Gimnasio gimnasio;
    public static void main(String[] args){
         gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

         //todo falta verificar cada vez que se prende el programa las cuotas
        //todo MAÑANA SE ENTREGA EL PROYECTO AAAAAAA:)
        System.out.println("Hello world");
       GUIEnvoltorio guiEnvoltorio = new GUIEnvoltorio();
       guiEnvoltorio.iniciarPrograma();

    }
}