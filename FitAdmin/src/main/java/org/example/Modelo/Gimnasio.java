package org.example.Modelo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Interfaces.IMetodosCrud;
import org.example.Interfaces.IEstadistica;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.*;

public class Gimnasio implements IEstadistica, IMetodosCrud<Cliente>
{
    //atributos
    private String nombre;
    private String direccion;
    private HashMap<Integer,Cliente> clientes;//INTEGER = GetIdSocio
    private String usuario;
    private String contrasenia;
    private ArrayList<Actividad> actividades;
    //constructores

    public Gimnasio(){
        nombre="Sin nombre";
        direccion="Sin direccion";
        usuario="Sin usuario";
        contrasenia="Sin contrasenia";
        clientes = new HashMap<>();
        actividades = new ArrayList<>();
    }

    public Gimnasio(String nombre, String direccion, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        clientes = new HashMap<>();
        actividades = new ArrayList<>();
    }

    //getters y setters

    public String getUsuario() {
        return usuario;
    }

    private String getContrasenia(){
        return contrasenia;
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }


    //metodos

    public boolean crearUnPDFRutina(Rutina rutina)
    {
        boolean rta = false;
        String dest = "rutina.pdf";
        try {
            // Crear un escritor de PDF
            PdfWriter writer = new PdfWriter(dest);

            // Crear un documento PDF
            PdfDocument pdf = new PdfDocument(writer);

            // Crear un documento de layout
            Document document = new Document(pdf);

            // Agregar un párrafo al documento
            document.add(new Paragraph(rutina.toString()));

            // Cerrar el documento
            document.close();
            rta = true;
            System.out.println("PDF creado con éxito.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return rta;
    }

    public void enviarUnMail(String mailCliente, String mensaje) throws MessagingException, MailSinArrobaE {
        //VERIFICAR SI TIENE UN ARROBA UNICAMENTE

        if (!mailCliente.contains("@")) //todo: agregar una excepcion
        {
            throw new MailSinArrobaE();
        }

        String mailFit = "f69343696@gmail.com"; //mail nuestro
        String contraFit = "xpve mrro kysx ishp"; //contrasenia de app de google
        Properties props = new Properties(); //conjunto de propiedades para la autenticacion/verificacion

            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //NO BORRAR LA AUTENTICACION DEBIDO A QUE ES INDISPENSABLE

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() //inicio de sesion
            {
                protected PasswordAuthentication getPasswordAuthentication() //autenticacion de contrasenia
                {
                    return new PasswordAuthentication(mailFit, contraFit); //retornamos si se autentico correctamente la contrasenia
                }
            });

            try{
                //todo: verificar el try catch ya que tiene q estar fuera de la clase(throws)

                MimeMessage message = new MimeMessage(session); //creamos el mensaje para construirlo
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailCliente, true)); //mail del cliente a enviar
                message.setSubject("Sistema automatico FitAdmin. Importante aviso"); //el titulo
                message.setText(mensaje); //mensaje

                // Adjuntar el archivo PDF
                String rutaPDF = "rutina.pdf";//direccion de la rutina general
                Multipart multipart = new MimeMultipart();// Creamos un objeto MimeMultipart para manejar múltiples partes del mensaje
                MimeBodyPart messageBodyPart = new MimeBodyPart();// Creamos una parte del cuerpo del mensaje y establecemos el texto del mensaje
                messageBodyPart.setText(mensaje);
                multipart.addBodyPart(messageBodyPart);// Agregamos la parte del cuerpo del mensaje al objeto MimeMultipart

                MimeBodyPart attachmentPart = new MimeBodyPart();// Creamos otra parte del cuerpo del mensaje para el archivo adjunto
                DataSource source = new FileDataSource(rutaPDF);// Creamos un DataSource utilizando la ruta del archivo PDF
                attachmentPart.setDataHandler(new DataHandler(source));// Configuramos el manejador de datos de la parte del cuerpo del archivo adjunto
                attachmentPart.setFileName(new File(rutaPDF).getName());// Establecemos el nombre del archivo adjunto utilizando el nombre del archivo PDF
                multipart.addBodyPart(attachmentPart);// Agregamos la parte del cuerpo del archivo adjunto al objeto MimeMultipart

                message.setContent(multipart);// Establecemos el contenido del mensaje como el objeto MimeMultipart que contiene tanto el cuerpo del mensaje como el archivo adjunto


                Transport.send(message); // clase message finalizada y enviada por mail
            }catch (MessagingException me){
                throw me;
            }




    }


    @Override
    public boolean agregar(Cliente nuevoCliente) {
        //agregamos un nuevo cliente con estado true
        boolean flag=false;
        if (!clientes.containsKey(nuevoCliente.getIdSocio())) //si el nuevo cliente no tiene el mismo ID que los ya registrados, se agrega
        {
            clientes.put(nuevoCliente.getIdSocio(),nuevoCliente);
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean archivar(Cliente clienteAArchivar) {
        //modificamos el estado del cliente false
        boolean flag=false;
        if (clienteAArchivar.isEstado() || clientes.containsKey(clienteAArchivar.getIdSocio())) //si el estado es true y el id cliente existe, entonces se puede archivar
        {
            clienteAArchivar.setEstado(false);
            flag=true;
        }
        return flag;
    }

    @Override
    public Cliente buscar(Integer idSocioBuscar)
    {
        //bussco y retorno un cliente en el hashmap si no existe retorno null
        Cliente clienteBuscado=null;
        if (clientes.containsKey(idSocioBuscar))
        {
            clienteBuscado = clientes.get(idSocioBuscar);
        }
        return clienteBuscado;
    }

    @Override
    public String listar() {
        return clientes.toString();
    }


    public void guardarClientesEnArchivo(String nombreDelArchivo)
    {
//todo: ser porque es una serializacion de una coleccion (por convencion) sino usaria .bin
        try (FileOutputStream fileOut = new FileOutputStream(nombreDelArchivo);//permite el flujo de salida de datos
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {//crea un flujo de salida de objetos a partir de los datos(bytes)

            out.writeObject(clientes);//todo: me permite escribir el archivo hacerlo gracias a la implementacion Serializable

        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    public void leerArchivoCliente(String nombreDelArchivo)
    {
        try (FileInputStream fileIn = new FileInputStream(nombreDelArchivo);//permite el flujo de entrada de datos
             ObjectInputStream in = new ObjectInputStream(fileIn)) {//crea un flujo de entrada de objetos a partir de los datos(bytes)

            clientes = (HashMap<Integer, Cliente>) in.readObject();//lee en ese tipo de formato

        } catch (IOException i) {
            System.err.println("Error de entrada/salida: " + i.getMessage());
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.err.println("Clase Cliente no encontrada");
            c.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public int contarTotalClientes() {
        //retorno el total de clientes que es igual al tamanio del mapa
        return clientes.size();
    }

    @Override
    public int contarClientesActivos() {
        //recorro el mapa con iterator y analizo los clientes activos y los acumulo
        int cont=0;
        Iterator<Map.Entry<Integer,Cliente>> iterator= clientes.entrySet().iterator();

        while (iterator.hasNext())
        {
            Cliente auxCliente= iterator.next().getValue();
            if (auxCliente.isEstado())
            {
                cont++;
            }
        }

        return cont;
    }

    @Override
    public int contarClientesInactivos() {
        //idem clientesActivos pero con Inactivos
        int cont=0;
        Iterator<Map.Entry<Integer,Cliente>> iterator= clientes.entrySet().iterator();

        while (iterator.hasNext())
        {
            Cliente auxCliente= iterator.next().getValue();
            if (!auxCliente.isEstado())
            {
                cont++;
            }
        }

        return cont;
    }

    @Override
    public int contarClientesXGenero(String genero) {
        //recorro el mapa con iterator y analizo los clientes X genero y los acumulo
        int cont=0;
        Iterator<Map.Entry<Integer,Cliente>> iterator= clientes.entrySet().iterator();


        while (iterator.hasNext())
        {
            Cliente auxCliente= iterator.next().getValue();
            if (auxCliente.getSexo().equalsIgnoreCase(genero))
            {
                cont++;
            }
        }

        return cont;
    }

    @Override
    public int contarClientesXActividad(String actividad) {
        //recorro el mapa con iterator y analizo los clientes X una actividad y los acumulo
        int cont=0;
        Iterator<Map.Entry<Integer,Cliente>> iterator= clientes.entrySet().iterator();

        while (iterator.hasNext()) // recorro todos los clientes
        {
            Cliente auxCliente= iterator.next().getValue();

            for (Actividad auxActividad : auxCliente.getActividadesInscripto()) //recorro todas las actividades de ese cliente
            {
                if (auxActividad.obtenerNombreActividad().equalsIgnoreCase(actividad)) //si contiene la actividad buscada aumento el contador
                {
                    cont++;
                }
            }
        }

        return cont;
    }

    @Override
    public double recaudacionTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", clientes="+"\n " + clientes +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", actividades=" + actividades +
                '}';
    }
}
