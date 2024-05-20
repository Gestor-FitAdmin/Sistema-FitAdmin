package org.example;

import com.dropbox.core.DbxException;
import org.example.Enum.EDiasSemana;
import org.example.Enum.EObjetivo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, DbxException {
        Gimnasio gimnasio= new Gimnasio("fitAdmin","Villa urquiza","gonza","velez2do");

        Cliente cliente = new Cliente("Leo","Caimmi","46012540","masculino",75.5,182.5,"09/07/2004",1,"facundoprocelli@gmail.com",true);
        Rutina rutina = new Rutina(EObjetivo.GANAR_MUSCULO);

        ArrayList< Ejercicio> ejercicios = rutina.leerJSON("ejercicios.json");

        Ejercicio ejercicio = ejercicios.get(0);
        ejercicio.setRepeticiones(10);
        ejercicio.setSeries(4);
        rutina.agregarUnEjercicioARutina(ejercicio);

        /*cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.LUNES);
        cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.MARTES);
        cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.MIERCOLES);
        cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.JUEVES);
       cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.VIERNES);
        cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.SABADO);
        cliente.asignarUnaRutinaAUnDia(rutina,EDiasSemana.DOMINGO);

        gimnasio.CrearUnPDFConUnaRutina(cliente);
        try {
            gimnasio.enviarUnMail(cliente.geteMail(),"PRUEBA 123",true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (MailSinArrobaE e) {
            throw new RuntimeException(e);
        }*/
        gimnasio.crearPDFParaQR(cliente);

    }
}