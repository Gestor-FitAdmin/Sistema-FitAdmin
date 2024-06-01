package org.example;

import org.example.Enum.ESexo;
import org.example.GUI.*;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
   public static  Gimnasio gimnasio;
    public static void main(String[] args) {
         gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

         LocalDate fecha= LocalDate.parse("30-05-2005",DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Cliente cliente = new Cliente("Leo", "Caimmi", "46012540", ESexo.MASCULINO, 75.5, 182.5, fecha, "facundoprocelli@gmail.com", true);
        Cliente cliente1 = new Cliente("asd", "awerger", "34534", ESexo.FEMENINO, 75.5, 182.5, fecha, "fabri.vogol@gmail.com", true);
        Cliente cliente2 = new Cliente("Leasdaso", "aerh", "754457", ESexo.MASCULINO, 75.5, 182.5, fecha, "facundoprocelli@gmail.com", true);
//
       GUIEnvoltorio guiEnvoltorio = new GUIEnvoltorio();

        GUIEnvoltorio.getGimnasio().agregar(cliente);
        GUIEnvoltorio.getGimnasio().agregar(cliente1);
        GUIEnvoltorio.getGimnasio().agregar(cliente2);
        //logro github...


        guiEnvoltorio.iniciarPrograma();

//        JfrCliente jfrCliente = new JfrCliente();
//        jfrCliente.setVisible(true);

//        System.out.println(cliente.getFechaDeNacimiento()+" " +cliente.getEdad());
//        JfrGenerarRutina jfrGenerarRutina= new JfrGenerarRutina(cliente);
//        jfrGenerarRutina.setVisible(true);



        GUIEnvoltorio.getGimnasio().leerMails();








    }
}