package org.example;

import com.dropbox.core.DbxException;
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

        Cliente cliente = gimnasio.crearClienteConRutina(EDiasSemana.LUNES);
        gimnasio.crearPDFRutinaSemanal(cliente);
       /* try {
            gimnasio.enviarUnMail("fabri.vogol@gmail.com","Prueba formato rutina");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (MailSinArrobaE e) {
            throw new RuntimeException(e);
        }*/



    }
}