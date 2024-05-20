package org.example;

import com.dropbox.core.DbxException;
import org.example.API.DropBoxAPI;
import org.example.Enum.EDiasSemana;
import org.example.Enum.EObjetivo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DbxException {
        Gimnasio gimnasio= new Gimnasio("fitAdmin","Villa urquiza","gonza","velez2do");



        DropBoxAPI asd= new DropBoxAPI();
        asd.obtenerURL("rutina.pdf");

    }
}