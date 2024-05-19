package org.example;

import org.example.Enum.EObjetivo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gimnasio gimnasio= new Gimnasio("asd","asd","wfg","egasd");

        try {
            gimnasio.enviarUnMail("asdasfd","hola");
        }
        catch (MailSinArrobaE e)
        {
            System.out.println(e.getMessage());
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}