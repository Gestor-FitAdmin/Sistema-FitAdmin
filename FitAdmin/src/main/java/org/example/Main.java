package org.example;

import com.dropbox.core.DbxException;
import org.example.API.QrAPI;
import org.example.Enum.EObjetivo;
import org.example.Enum.ESexo;
import org.example.GUI.*;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Main {
   public static  Gimnasio gimnasio;
    public static void main(String[] args) {
         gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

         LocalDate fecha= LocalDate.of(2005,05,23);

        Cliente cliente = new Cliente("Leo", "Caimmi", "46012540", ESexo.MASCULINO, 75.5, 182.5, fecha, "facundoprocelli@gmail.com", true);
        Cliente cliente1 = new Cliente("asd", "awerger", "34534", ESexo.FEMENINO, 75.5, 182.5, fecha, "facundoprocelli@gmail.com", true);
        Cliente cliente2 = new Cliente("Leasdaso", "aerh", "754457", ESexo.MASCULINO, 75.5, 182.5, fecha, "facundoprocelli@gmail.com", true);
//
        GUIEnvoltorio guiEnvoltorio = new GUIEnvoltorio();

        GUIEnvoltorio.getGimnasio().agregar(cliente);
        GUIEnvoltorio.getGimnasio().agregar(cliente1);
        GUIEnvoltorio.getGimnasio().agregar(cliente2);
        //logro github...
//
//        System.out.println(GUIEnvoltorio.getGimnasio().getClientes());

        /*
        Rutina rutina = new Rutina(EObjetivo.GANAR_MUSCULO);

        DropBoxAPI dropBoxAPI;

        dropBoxAPI = new DropBoxAPI();

        QrAPI qrAPI = new QrAPI();


        gimnasio.crearPDFParaQR(cliente);

        dropBoxAPI.subirPDF("QRaGenerar.pdf"); // subirlo a dropbox
        String url = dropBoxAPI.obtenerURL("QRaGenerar"); //recordar subir solo el nombre del archivo que esta en dropbox
       System.out.println(url);
        qrAPI.generarQr(url);

         */


        //guiEnvoltorio.iniciarPrograma();

        System.out.println(cliente.getFechaDeNacimiento()+" " +cliente.getEdad());
        JfrGenerarRutina jfrGenerarRutina= new JfrGenerarRutina(cliente);
        jfrGenerarRutina.setVisible(true);

    }
}