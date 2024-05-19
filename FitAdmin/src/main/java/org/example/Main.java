package org.example;

import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gimnasio gimnasio= new Gimnasio("fitAdmin","Villa urquiza","gonza","velez2do");

//        try {
//            gimnasio.enviarUnMail("asdasfd","hola");
//        }
//        catch (MailSinArrobaE e)
//        {
//            System.out.println(e.getMessage());
//        }
//        catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
       gimnasio.leerArchivoCliente("clientes.ser");
       //System.out.println("LO QUE ESTA EN EL ARCHIVO");
        //System.out.println(gimnasio);

       /*gimnasio.agregar(new Cliente("LEO","CAIMMI","46012540","Masculino",75.0,182.5,"09/07/2004",1,"leonardo11@icloud.com",true));
        gimnasio.agregar(new Cliente("FABRI","VOGOL","46778234","Masculino",80.0,178.5,"11/04/2005",2,"fabrivogol@gmial.com",true));
        gimnasio.agregar(new Cliente("FACU","PROCELLI","46012111","Masculino",73.0,184.5,"25/11/2004",3,"facundoprocelli@gmail.com",true));*/

       /*System.out.println("LO QUE ESTABA EN EL ARCHIVO + LO QUE ES NUEVO");
        System.out.println(gimnasio);
        System.out.println("GUARDO TODO");
        gimnasio.guardarClientesEnArchivo("clientes.ser");*/

        System.out.println(gimnasio);


    }
}