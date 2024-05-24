package org.example;

import com.dropbox.core.DbxException;
import org.example.API.DropBoxAPI;
import org.example.API.QrAPI;
import org.example.Enum.EObjetivo;
import org.example.GUI.GUIEnvoltorio;
import org.example.GUI.JfrGenerarRutina;
import org.example.GUI.JfrLogIn;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import java.io.IOException;


public class Main {
   public static  Gimnasio gimnasio;
    public static void main(String[] args) {
         gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

        /*
        Cliente cliente = new Cliente("Leo", "Caimmi", "46012540", "masculino", 75.5, 182.5, "09/07/2004", 1, "facundoprocelli@gmail.com", true);
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


        GUIEnvoltorio guiEnvoltorio = new GUIEnvoltorio();
        guiEnvoltorio.iniciarPrograma();


    }
}