package org.example;

import org.example.Enum.ESexo;
import org.example.GUI.*;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
   public static  Gimnasio gimnasio;
    public static void main(String[] args){
         gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

//
       GUIEnvoltorio guiEnvoltorio = new GUIEnvoltorio();
       guiEnvoltorio.iniciarPrograma();
    }
}