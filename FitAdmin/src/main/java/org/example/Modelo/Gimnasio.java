package org.example.Modelo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Gimnasio
{
    //atributos
    private String nombre;
    private String direccion;
    private HashMap<Integer,Cliente> clientes;//INTEGER = GetIdSocio
    private String usuario;
    private String contrasenia;
    private ArrayList<Actividad> actividades;
    //constructores

    public Gimnasio(String nombre, String direccion, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;

        clientes = new HashMap<>();
        actividades = new ArrayList<>();
    }

    //getters y setters

    //metodos

    public void enviarUnMail(String mailCliente, String mensaje){
        //VERIFICAR SI TIENE UN ARROBA UNICAMENTE

        String mailFit = "f69343696@gmail.com"; //mail nuestro
        String contraFit = "xpve mrro kysx ishp"; //contrasenia de app de google



        Properties props = new Properties(); //conjunto de propiedades para la autenticacion/verificacion
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        //NO BORRAR LA AUTENTICACION DEBIDO A QUE ES INDISPENSABLE

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { //inicio de sesion
            protected PasswordAuthentication getPasswordAuthentication() { //autenticacion de contrasenia
                return new PasswordAuthentication(mailFit, contraFit); //retornamos si se autentico correctamente la contrasenia
            }
        });

        try{
            //verificar el try catch ya que tiene q estar fuera de la clase(throws)

            MimeMessage message = new MimeMessage(session); //creamos el mensaje para construirlo
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailCliente, true)); //mail del cliente a enviar
            message.setSubject("Sistema automatico FitAdmin. Importante aviso"); //el titulo
            message.setText(mensaje); //mensaje

            Transport.send(message); // clase message finalizada y enviada por mail
        }catch (MessagingException me){
            System.out.println("Exception: "+me);
        }
    }

}
