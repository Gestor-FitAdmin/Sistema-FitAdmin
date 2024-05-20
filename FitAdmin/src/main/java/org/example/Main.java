package org.example;

import com.dropbox.core.DbxException;
import org.example.API.DropBoxAPI;
import org.example.Enum.EObjetivo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DbxException {
        Gimnasio gimnasio= new Gimnasio("fitAdmin","Villa urquiza","gonza","velez2do");


        System.out.println(gimnasio.crearUnPDFRutina(new Rutina(EObjetivo.GANAR_MUSCULO)));
        try {
            gimnasio.enviarUnMail("fabri.vogol@gmail.com","Hola vogol");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (MailSinArrobaE e) {
            throw new RuntimeException(e);
        }

    }
}