package org.example.Modelo;

import com.dropbox.core.DbxException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import org.example.API.DropBoxAPI;
import org.example.Enum.ESexo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Excepciones.TokenDeAccesoInvalidoE;
import org.example.GUI.GUIEnvoltorio;
import org.example.GUI.PopUps.JfrAutenticacionPopUp;
import org.example.Interfaces.IMetodosCrud;
import org.example.Interfaces.IEstadistica;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static javax.management.remote.JMXConnectorFactory.connect;

public class Gimnasio implements IEstadistica, IMetodosCrud<Cliente> {
    //atributos
    private String nombre;
    private String direccion;
    private HashMap<Integer, Cliente> clientes;//INTEGER = GetIdSocio
    private String usuario;
    private String contrasenia;
    private ArrayList<Actividad> actividades;

    private static String mailFit = "f69343696@gmail.com"; //mail nuestro
    private static String contraFit = "xpve mrro kysx ishp"; //contrasenia de app de google

    //constructores

    public Gimnasio() {
        nombre = "Sin nombre";
        direccion = "Sin direccion";
        usuario = "Sin usuario";
        contrasenia = "Sin contrasenia";
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

    public String getContrasenia() {
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

    public void crearUnPDFConUnaRutina(Cliente cliente) {

        String dest = "rutina.pdf";//ruta de donde se guarda el PDF
        try {

            PdfWriter writer = new PdfWriter(dest);// Crear un escritor de PDF


            PdfDocument pdf = new PdfDocument(writer);// Crear un documento PDF


            Document document = new Document(pdf);// Crear un documento de layout


            for (Map.Entry<String, Rutina> entry : cliente.getRutinaSemanal().entrySet()) { // Iterar sobre las entradas del HashMap

                document.add(new Paragraph("Día: " + entry.getKey())); // Agregar el día de la rutina como encabezado


                float[] columnWidths = {1, 1, 3};// Crear una tabla con 3 columnas (Ejercicio,Series, Repeticiones)
                Table table = new Table(columnWidths);

                // Agregar los encabezados de la tabla
                table.addHeaderCell(new Cell().add(new Paragraph("Ejercicio")));
                table.addHeaderCell(new Cell().add(new Paragraph("Series")));
                table.addHeaderCell(new Cell().add(new Paragraph("Repeticiones")));
                Rutina rutina1 = cliente.getRutinaSemanal().get(entry.getKey());
                // Agregar las filas de la rutina
                for (Ejercicio ejercicio : rutina1.getRutina()) {
                    table.addCell(new Cell().add(new Paragraph(ejercicio.getNombreEjercicio())));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(ejercicio.getSeries()))));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(ejercicio.getRepeticiones()))));
                }

                document.add(table); // Agregar la tabla al documento

                document.add(new Paragraph("\n"));// Agregar un salto de línea entre días
            }

            document.close();  // Cerrar el documento

        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }


    }

    public boolean crearPDFParaQR(Cliente cliente) {
        boolean rta = false;

        // Ruta del archivo PDF a crear
        String ruta = "QRaGenerar.pdf";


        try {
            DropBoxAPI dropBoxAPI= new DropBoxAPI();
            String rutaFotoPerfil="FitAdmin/fotoDePerfilPredeterminada.jpg"; //por defecto tiene una foto de perfil predeterminada


            // Ruta de la imagen de perfil
            if (cliente.isTieneFotoPerfil()) // si el cliente tiene foto de perfil
            {
                rutaFotoPerfil= dropBoxAPI.descargarArchivoDeDropbox(new File(cliente.getDNI())); // la busco en dropbox
                System.out.println(cliente);
                //cliente.setTieneFotoPerfil(true);//es momentaneo para luego poder borrarla de la carpeta, luego deja de tener foto de perfil porque el usuario es temporal
            }


            // Estado de acceso
            boolean accesoDelCliente = cliente.isCuotaPagada(); //esto nos dira si el cliente puede acceder o no


            // Crear el PdfWriter
            PdfWriter writer = new PdfWriter(ruta);
            // Crear el PdfDocument
            PdfDocument pdf = new PdfDocument(writer);
            // Crear el Document
            Document document = new Document(pdf);

            // Crear una tabla con dos columnas
            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            table.setWidth(UnitValue.createPercentValue(100));

            // Agregar imagen de perfil
            ImageData imageData = ImageDataFactory.create(rutaFotoPerfil);
            Image image = new Image(imageData);
            image.scaleToFit(240, 240); // Ajustar el tamaño de la imagen
            table.addCell(image);//agrega en la 1er columno la imagen

            // Crear un párrafo con la información del socio
            Paragraph infoParagraph = new Paragraph();
            String formatoConSaltosDeLinea = cliente.formatearDatosCliente(cliente);//"Número de socio: " + cliente.getIdCliente() + "\n" + "Nombre: " + cliente.getNombre() + "\n" + "Apellido:  " + cliente.getApellido()+"\n";
            infoParagraph.add(formatoConSaltosDeLinea);

            table.addCell(infoParagraph);//agrego los datos del cliente en la 2da columna

            // Agregar la tabla al documento
            document.add(table);

            // Agregar mensaje de acceso
            String mensajeDeAcceso;
            Paragraph accessParagraph = new Paragraph();

            if (accesoDelCliente)
            {
                mensajeDeAcceso = "ACCESO CONCEDIDO";
                accessParagraph.setFontColor(ColorConstants.GREEN);//si tiene la cuota pagada es concedido
            } else
            {
                mensajeDeAcceso = "ACCESO DENEGADO";
                accessParagraph.setFontColor(ColorConstants.RED);//si no tiene la cuota pagada es denegado
            }
            accessParagraph.add(mensajeDeAcceso).setFontSize(20).setTextAlignment(TextAlignment.CENTER);//tamaño y posicionamiento del mensaje de acceso

            document.add(accessParagraph);//añade el mensaje de acceso con sus ajustes


            // Cerrar el documento
            document.close();
            rta = true;
            if (cliente.isTieneFotoPerfil())
            {
                eliminarImagen(new File("FitAdmin/"+cliente.getDNI()+".jpg")); // elimino la foto de perfil si es que tiene 
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (TokenDeAccesoInvalidoE e) {
            e.printStackTrace();
        }
            cliente.setTieneFotoPerfil(false);//yo no se si el cliente va a cambiar lo foto o si no esta mas, entonces siempre la voy a querer buscar para generarle el acceso y luego eliminarla de mi carpeta/repositorio por eso la dejo en false
        return rta;

    }



    private Session getSesionMailIniciada(Properties props)
    {


        //todo: dependiendo las propiedades que reciba, retornarne una sesion con una funcion especifica.
        //ej: SMTP es SOLO Y EXCLUSIVAMENTE para enviar mails. IMAPS es para recibir y leer mails


        Session session = Session.getDefaultInstance(props, new Authenticator() //inicio de sesion
        {
            protected PasswordAuthentication getPasswordAuthentication() //autenticacion de contrasenia
            {
                return new PasswordAuthentication(mailFit, contraFit); //retornamos si se autentico correctamente la contrasenia
            }
        });
        return session;
    }


    public Cliente buscarClienteXDNI(String dniAComparar)
    {

        Cliente rta=null;

        for (Map.Entry<Integer, Cliente> entry : clientes.entrySet()) {

            Cliente clienteAux =entry.getValue();
            if(clienteAux.getDNI().equals(dniAComparar))
            {
                rta=clienteAux;
            }
        }

        return rta;
    }
    public boolean verificarDNIExistente(String dniAComparar)
    {

        boolean rta = false;
       // System.out.println(dniAComparar);
        for (Map.Entry<Integer, Cliente> entry : clientes.entrySet()) {

            Cliente siExiste =entry.getValue();
            //System.out.println(siExiste.getDNI());
            if(siExiste.getDNI().equals(dniAComparar))
            {
                rta = true;//es true si ya existe el DNI
            }
        }
        return rta;
    }

    private Properties propiedadesParaImap()
    {
        //esto retorna las propiedades para conectarme a Imap
        //propiedades para el tipo de conexion
        Properties props= new Properties();
        props.put("mail.store.protocol", "imaps"); //protocolo para recibir y leer mails
        props.put("mail.imap.host", "imap.gmail.com"); // este es el host del protocolo
        props.put("mail.imap.port", "993"); // IMAP con SSL/TLS: puerto 993. Es un puerto seguro
        props.put("mail.imap.ssl.enable", "true"); // activamos la seguridad
        return props;
    }

    public void leerMails(){

        Properties props= propiedadesParaImap();

        try {
        //obtengo la sesion con las propiedades especificadas
            Session session= getSesionMailIniciada(props);

        //creo una conexion con el servidor de correo
            IMAPStore imapStore= (IMAPStore) conectarConImap(session);

            //abro la bandeja de entrada
            IMAPFolder carpetaEmail = (IMAPFolder) obtenerCarpeta(imapStore);

            // Listener para eventos de la carpeta
            verificarMailsBandejaDeEntrada(carpetaEmail);

            //todo: hay dos problemas, el primero es que si hay inactividad x mucho tiempo se cierra (Hay un metodo x terminar para reconectarse).
            //todo: El otro es verificar si el programa funciona al 100% sin haber hecho un hilo nuevo ya que por el momento esta funcionando
            try {
                System.out.println("Esperando mensajes");

                while (true)
                {
                    carpetaEmail.idle();
                }

            }catch (FolderClosedException e)
            {
                System.out.println("Se cerro la conexion con el server debido a la inactividad");

                reconectarConServImap(carpetaEmail,imapStore);
            }



        }
        catch (Exception e)
        {
           e.printStackTrace();
        }



    }

    private void reconectarConServImap(Folder carpetaMail, Store imapStore) {
        //NO BORRAR FUNCION POR LAS DUDAS SI HAY QUE RECONECTARSE
        try {
            // Cerrar recursos existentes
            if (carpetaMail != null && carpetaMail.isOpen()) {
                carpetaMail.close(false);
            }
            if (imapStore != null && imapStore.isConnected()) {
                imapStore.close();
            }

            leerMails();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void verificarMailsBandejaDeEntrada(Folder carpetaEmail){

        carpetaEmail.addMessageCountListener(new MessageCountAdapter() {

            Cliente auxCliente=null; //creo un cliente

            @Override
            public void messagesAdded(MessageCountEvent e) {
                Message[] mensajes = e.getMessages(); //obtengo todos los mensajes NUEVOS

                System.out.println("Nuevos correos recibidos");

                //leo cada mensaje nuevo
                for (Message mensajeNuevo : mensajes) {
                    try {
                        //obtengo el titulo del mail que tendria que ser el DNI del cliente
                        String dniRecibido = mensajeNuevo.getSubject();

                        //verifico si existe el cliente x DNI
                        if (verificarDNIExistente(dniRecibido))
                        {
                            //obtengo el cliente para verificar si ya tiene foto de perfil
                            auxCliente= buscarClienteXDNI(dniRecibido);

                            if (!auxCliente.isTieneFotoPerfil())
                            {
                                //si no tiene foto de perfil verifico que lo que me mandaron sirva
                                System.out.println("Asunto: " + mensajeNuevo.getSubject());

                                if (mensajeNuevo.isMimeType("multipart/*")) {
                                    //obtengo el cuerpo si hay multiples partes (Ej texto e imagen). En este caso tiene que haber una imagen, y eso es lo que vamos a verificar

                                    Multipart multipartes = (Multipart) mensajeNuevo.getContent(); //casteo el contenido a un tipo de dato multiparte

                                    for (int j = 0; j < multipartes.getCount(); j++) {
                                        //recorro cada parte
                                        BodyPart parte = multipartes.getBodyPart(j); //esto es una parte del multipart singular

//                                            System.out.println("Revisando parte: " + j);
//                                            System.out.println("Disposición: " + parte.getDisposition());
//                                            System.out.println("Nombre del archivo: " + parte.getFileName());

                                        if ((Part.ATTACHMENT.equalsIgnoreCase(parte.getDisposition()) || Part.INLINE.equalsIgnoreCase(parte.getDisposition())) && verificarSiMensajeMailEsImagen(parte.getFileName())) {
                                            // Si la parte es una imagen, la guardo en el repo para subirla a dropbox
                                            // me doy cuenta que es una imagen ya que tiene que estar adjunta(ATTACHMENT o INLINE) y debe terminar en .jpg,.jpeg o .png
                                            // Procesar y guardar la imagen
                                            System.out.println("Entro a guardar imagen");
                                            auxCliente.setTieneFotoPerfil(true); // le pongo que ahora SI tiene foto de perfil
                                            System.out.println(auxCliente);

                                            String rutaDelArchivo= guardarImagenLeidaDeUnMail(parte,dniRecibido); // guardo la imagen en la carpeta FitAdmin

                                            guardarFotoPerfilEnDropbox(new File(rutaDelArchivo)); //guardo la imagen en dropbox

                                            eliminarImagen(new File(rutaDelArchivo)); // el file sera con el nombre del dni por lo tanto lo elimino con ese nombre


                                        }
                                    }
                                }
                            }
                            else{
                                //si ya tiene foto de perfil no se asigna nada
                                System.out.println("retornar un error al mail que nos envio el mensaje");
                            }
                        }

                    } catch (MessagingException me) {
                        me.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

private boolean verificarSiMensajeMailEsImagen(String nombreArchivo)
{
    boolean flag=false;
    if (nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith("png"))
    {
        flag=true;
    }
    return flag;
}

    private Folder obtenerCarpeta(IMAPStore imapStore) throws MessagingException {
        IMAPFolder carpetaEmail = (IMAPFolder) imapStore.getFolder("INBOX");
        carpetaEmail.open(Folder.READ_ONLY);
        return carpetaEmail;
    }

    private Store conectarConImap(Session sesionImap) throws MessagingException {
        IMAPStore store= (IMAPStore) sesionImap.getStore();
        store.connect("imap.gmail.com",mailFit,contraFit);
        return store;
    }



    public void eliminarImagen(File archivo)
    {
        System.out.println("Imagen eliminada de la carpeta nuestra, quedo en dropbox");
        if (archivo.exists())
        {
            boolean flag= archivo.delete();
        }

    }

    public String guardarImagenLeidaDeUnMail(BodyPart parte,String nombreDelArchivo) throws MessagingException, IOException {

        String destinoRutaArchivo = "FitAdmin/"+ nombreDelArchivo + ".jpg"; //quiero ponerle este nombre al archivo que voy a crear

        InputStream inputStream = parte.getInputStream();// abro un canal de datos de input

        Path pathArchivo= Path.of(destinoRutaArchivo);//convierto string a ruta

        Files.copy(inputStream,pathArchivo); // copio la foto recibida del mail, a la carpeta/repositorio actual

       // Files.deleteIfExists(pathArchivo);//si el archivo existe lo elimino, sino tira FileAlreadyExistsException

        inputStream.close(); // cierro el canal de datos de input

        System.out.println("Imagen guardada exitosamente");
        return destinoRutaArchivo; // esto me va a retornar donde se encuentra la imagen guardada
    }

    public void guardarFotoPerfilEnDropbox(File archivo){
        try {
            DropBoxAPI dropBoxAPI =new DropBoxAPI();
            dropBoxAPI.subirArchivo(archivo,"/fotosDePerfil/");

            System.out.println("Imagen subida exitosamente a dropbox");
        }catch (TokenDeAccesoInvalidoE e)
        {
            //token deberia estar autenticado
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            //no se encontro el archivo
            e.printStackTrace();
        } catch (DbxException e) {
            //problema con dropbox
           e.printStackTrace();
        }
    }

    public void enviarUnMail(String mailCliente, String mensaje, boolean adjuntarPDF) throws MessagingException, MailSinArrobaE {
        //VERIFICAR SI TIENE UN ARROBA UNICAMENTE

        if (!mailCliente.contains("@"))
        {
            throw new MailSinArrobaE();
        }

        Properties props = new Properties(); //conjunto de propiedades para la autenticacion/verificacion

        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host. solo para enviar mails
        props.put("mail.smtp.port", "587"); //puerto con autenticacion TLS. puerto seguro
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Session session= getSesionMailIniciada(props);

        try{
            //todo: verificar el try catch ya que tiene q estar fuera de la clase(throws)

            MimeMessage message = new MimeMessage(session); //creamos el mensaje para construirlo
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailCliente, true)); //mail del cliente a enviar
            message.setSubject("Sistema automatico FitAdmin. Importante aviso"); //el titulo
            message.setText(mensaje); //mensaje

            // Adjuntar el archivo PDF
            if(adjuntarPDF)//todo: si quiero enviar con un PDF le pongo true si no false y envio un mensaje unicamente!!
            {


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
            }

            Transport.send(message); // clase message finalizada y enviada por mail
        }catch (MessagingException e){

            throw e;
        }




    }


    public ArrayList<Cliente> retornarListaDeClientes()
    {
        ArrayList<Cliente> clienteArrayList= new ArrayList<>();
        Cliente clienteAux;

        for (Map.Entry<Integer, Cliente> integerClienteEntry : clientes.entrySet()) {

            clienteAux = integerClienteEntry.getValue();
            clienteArrayList.add(clienteAux);
        }

        return clienteArrayList;
    }

    public boolean verificarSiExisteClienteXId(int idBuscado){
        boolean flag=false;
        if (clientes.containsKey(idBuscado))
        {
            flag=true;
        }
        return flag;
    }

    private int buscarUltimoID()
    {
        //recorro el mapa y busco el ultimo id
        int ultimoId=0, auxInt=0;

        if (!clientes.isEmpty())
        {

            Iterator<Map.Entry<Integer,Cliente>> mapIterator= clientes.entrySet().iterator();
            while(mapIterator.hasNext())
            {
                auxInt= mapIterator.next().getKey(); //obtengo la key ya que es el ID del cliente
                if (auxInt> ultimoId)
                {
                    ultimoId= auxInt;
                }
            }
        }


        //si no hay ningun id, retornaria 1

        return ultimoId;
    }

    @Override
    public boolean agregar(Cliente nuevoCliente) {
        //agregamos un nuevo cliente con estado true
        boolean flag=true;

        nuevoCliente.setIdCliente(buscarUltimoID()+1); // aumento en 1 el ultimo id

        clientes.put(nuevoCliente.getIdCliente(),nuevoCliente);

        return flag;
    }

    @Override
    public boolean archivar(Cliente clienteAArchivar) {
        //modificamos el estado del cliente false
        boolean flag=false;
        if (clienteAArchivar.isEstado() && clientes.containsKey(clienteAArchivar.getIdCliente())) //si el estado es true y el id cliente existe, entonces se puede archivar
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

    public void leerArchivoCliente(String nombreDelArchivo)
    {
        ObjectInputStream in = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(nombreDelArchivo);//permite el flujo de entrada de datos
            in = new ObjectInputStream(fileIn);//crea un flujo de entrada de objetos a partir de los datos(bytes)

            while(true)//hasta que rompa el archivo
            {
                Cliente cliente = (Cliente) in.readObject();
                clientes.put(cliente.getIdCliente(),cliente);
            }
        } catch (EOFException e)
        {
            //e.getMessage();
            //e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.getMessage();
        }
        finally
        {
            try
            {
                in.close();//cierro el flujo de datos
            }catch (IOException e)
            {
                e.getMessage();
                e.printStackTrace();
            }
        }

    }
    public void guardarClientesEnArchivo(String nombreDelArchivo)
    {
        ObjectOutputStream out = null;
        try
        {
            System.out.println("Entro al try 1");
            int i = 0;
            FileOutputStream fileOut = new FileOutputStream(nombreDelArchivo);//permite el flujo de salida de datos
            out = new ObjectOutputStream(fileOut);//crea un flujo de salida de objetos a partir de los datos(bytes)

            System.out.println("Creo el objeto");
            Iterator<Map.Entry<Integer, Cliente>> entryIterator = clientes.entrySet().iterator();//Itero todos los clientes
            while(entryIterator.hasNext())
            {
                System.out.println("Escribo los values en el archivo");
                Map.Entry<Integer,Cliente> entry = entryIterator.next();//entrada del mapa para avanzar
                out.writeObject(entry.getValue());//tengo todos los clientes
                System.out.println("Aca yo lo escribi");
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                out.close();//cierro el flujo de datos
            } catch (IOException e)
            {
                System.out.println("Cuando quiero cerrar el archivo");
            }
        }

    }
    //modificar un cliente
    public boolean modificarDNIxIDSocio(Integer id,String nuevoDNI)//recibo el ID,recibo el DNI por la GUI
    {
        boolean rta = false;
        if(clientes.containsKey(id))
        {
            Persona clienteAModificar =(Cliente) clientes.get(id);//metodo de sustitucion para poder settear el DNI
            if(!clienteAModificar.getDNI().equals(nuevoDNI))//si el DNI no es el mismo que ya esta
            {
                clienteAModificar.setDNI(nuevoDNI);
                rta = true;//fue correcta la modificacion
            }
        }

        return rta;
    }
    public boolean modificarNombrexIDSocio(Integer id,String nuevoNombre)//recibo el ID,recibo el Nombre por la GUI
    {
        boolean rta = false;
        if(clientes.containsKey(id))//si contengo ese ID
        {
            Persona clienteAModificar =(Cliente) clientes.get(id);//metodo de sustitucion para poder settear el nombre
            if(!clienteAModificar.getNombre().equals(nuevoNombre))//si el nombre no es el mismo que ya esta
            {
                clienteAModificar.setNombre(nuevoNombre);
                rta = true;//fue correcta la modificacion
            }
        }
        return rta;
    }
    public boolean modificarApellidoxIDSocio(Integer id,String nuevoApellido)//recibo el ID,recibo el apellido por la GUI
    {
        boolean rta = false;
        if(clientes.containsKey(id))//si contengo ese ID
        {
            Persona clienteAModificar =(Cliente) clientes.get(id);//metodo de sustitucion para poder settear el apellido
            if(!clienteAModificar.getApellido().equals(nuevoApellido))//si el apellido no es el mismo que ya esta
            {
                clienteAModificar.setApellido(nuevoApellido);
                rta = true;//fue correcta la modificacion
            }
        }
        return rta;
    }
    public boolean modificarEmailxIDSocio(Integer id,String nuevoEmail)//recibo el ID,recibo el apellido por la GUI
    {
        boolean rta = false;
        if(clientes.containsKey(id))//si contengo ese ID
        {
            Cliente clienteAModificar =(Cliente) clientes.get(id);
            if(!clienteAModificar.geteMail().equals(nuevoEmail))//si el Email no es el mismo que ya esta
            {
                clienteAModificar.seteMail(nuevoEmail);
                rta = true;//fue correcta la modificacion
            }
        }
        return rta;
    }
    public boolean modificarAlturaxIDSocio(Integer id, Double nuevaAltura)//recibo el ID y la nueva altura
    {
        boolean rta = false;
        if(clientes.containsKey(id))
        {
            Persona clienteAModificar =(Cliente) clientes.get(id);//sustitucion para tener la altura de la Persona
            if(!clienteAModificar.getAltura().equals(nuevaAltura))//si la altura no es la misma que ya esta
            {
                clienteAModificar.setAltura(nuevaAltura);
                rta = true;
            }
        }

        return rta;
    }
    public boolean modificarPesoxIDSocio(Integer id, Double nuevoPeso)//recibo el ID y el nuevo peso
    {
        boolean rta = false;
        if(clientes.containsKey(id))
        {
            Persona clienteAModificar =(Cliente) clientes.get(id);//sustitucion para tener la altura de la Persona
            if(!clienteAModificar.getPeso().equals(nuevoPeso))//si el peso no es la misma que ya esta
            {
                clienteAModificar.setPeso(nuevoPeso);
                rta = true;
            }
        }

        return rta;
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
    public int contarClientesXGenero(ESexo sexoBuscado) {
        //recorro el mapa con iterator y analizo los clientes X genero y los acumulo
        int cont=0;
        Iterator<Map.Entry<Integer,Cliente>> iterator= clientes.entrySet().iterator();


        while (iterator.hasNext())
        {
            Cliente auxCliente= iterator.next().getValue();
            if (auxCliente.getSexo() == sexoBuscado)
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

            for (String auxActividad : auxCliente.getActividadesInscripto()) //recorro todas las actividades de ese cliente
            {
                if (auxActividad.equalsIgnoreCase(actividad)) //si contiene la actividad buscada aumento el contador
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
