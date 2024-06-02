package org.example.API;


import java.io.*;

import com.dropbox.core.*;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;

import com.dropbox.core.v2.files.*;


import java.util.Date;

/**
 DropBoxAPI dropBoxAPI= new DropBoxAPI();
 QrAPI qrAPI= new QrAPI();

 gimnasio.crearPDFParaQR(cliente);

 dropBoxAPI.subirPDF("pdfDatosCliente/QRaGenerar.pdf"); // subirlo a dropbox
 String url= dropBoxAPI.obtenerURL("QRaGenerar"); //recordar subir solo el nombre del archivo que esta en dropbox
 qrAPI.generarQr(url);
 */
//todo: verificar si el TOKEN se vence

import com.dropbox.core.v2.users.FullAccount;
import org.example.Excepciones.TokenDeAccesoInvalidoE;


public class DropBoxAPI {

    private static final String APP_KEY = "txclgtve4z6nla2";
    private static final String APP_SECRET = "4l7sllt3ezkyhuf";
    private static final String ACCESS_TOKEN_FILE = "access_token.txt";
    private static final DbxRequestConfig config= DbxRequestConfig.newBuilder("dropbox/fitAdmin").build();;
    private static final DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET); // app info me da la informacion de la app fitAdmin creada en dropbox


    private DbxClientV2 cliente;
    private String accessToken;


    public DropBoxAPI() throws TokenDeAccesoInvalidoE {
        accessToken = leerTokenDeAcceso();

        if(accessToken != null)
        {
            if (verificarSiElTokenEsValido(accessToken))
            {
                iniciarCliente(accessToken);
            }
            else {
                throw new TokenDeAccesoInvalidoE();
            }
        }
        else
        {
            crearYEscrbirArchivo();
        }
    }

    private void crearYEscrbirArchivo()
    {
        // esto es por si el archivo esta corrupto
        File file = new File(ACCESS_TOKEN_FILE);

        // Utilizamos try-with-resources para asegurarnos de que el BufferedWriter se cierra adecuadamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Sin token no tenes QR...");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iniciarCliente(String accessToken){


        if (accessToken == null || accessToken.isEmpty()) //si el access token es null o esta vacio
        {
            throw new IllegalArgumentException();
        }
        else // si no esta vacio creo el cliente
        {


            if (verificarSiElTokenEsValido(accessToken))
            {
                cliente = new DbxClientV2(config, accessToken);
            }

        }
    }

    public static boolean verificarSiElTokenEsValido(String token){
        DbxClientV2 clientePrueba= new DbxClientV2(config,token);
        boolean flag=false;
        try {
            FullAccount currentAccount = clientePrueba.users().getCurrentAccount();
            flag=true;
        } catch (DbxException e) {
            flag=false;
        }

        return flag;
    }

    public static String autenticarCliente(String codigoDeAcceso)throws DbxException{
        String tokenDeAcceso=null;


//        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
//        String authorizeUrl = webAuth.start();
//
//       /** System.out.println("1. Ve a: " + authorizeUrl);
//        System.out.println("2. Haz clic en \"Permitir\" (puede que necesites iniciar sesión primero)");
//        System.out.println("3. Copia el código de autorización."); ESTO ME SIRVE PARA LA CONSOLA. NO PARA LA GUI*/
//
        DbxWebAuth webAuth = new DbxWebAuth(config, appInfo);
        DbxWebAuth.Request webAuthRequest = DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .withTokenAccessType(TokenAccessType.OFFLINE) // This will request a refresh token
                .build();

        DbxAuthFinish authFinish;



        try {
           /** BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String code = br.readLine().trim();*/

            authFinish = webAuth.finishFromCode(codigoDeAcceso);
            tokenDeAcceso= authFinish.getAccessToken();

        }catch (DbxException e) {
           throw new DbxException("Token expirado");
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }


        return tokenDeAcceso;
    }

    public static String autenticarTokenNuevoURL()//me sirve para el popUp
    {
        DbxWebAuth webAuth = new DbxWebAuth(config, appInfo);
        DbxWebAuth.Request webAuthRequest = DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .withTokenAccessType(TokenAccessType.OFFLINE) // This will request a refresh token
                .build();

        String authorizeUrl = webAuth.authorize(webAuthRequest);

        return authorizeUrl;
    }

    public static void guardarTokenEnArchivo(String accessToken) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCESS_TOKEN_FILE))) {
            writer.write(accessToken);
        }catch (IOException e)
        {
            e.getMessage();
        }

    }

    public static String leerTokenDeAcceso(){
        File file = new File(ACCESS_TOKEN_FILE);
        String token=null;// si el archivo no existe retorno null

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                if (reader.ready()) // .ready verifica si hay espacios en blanco
                {
                    token= reader.readLine().trim(); //si el archivo no contiene nada devuelve string vacia
                }
            } catch (IOException e) {
               token=null;
            }
        }


        return token;
    }

    public FullAccount getCurrentAccount() throws Exception
    {
        if (cliente == null) {
            throw new IllegalStateException("Dropbox client is not initialized.");
        }
        return cliente.users().getCurrentAccount();
    }

    public void subirArchivo(File archivo,String ubicacion)throws FileNotFoundException,DbxException{

        InputStream inputStream; // crea una entrada del archivo

        ubicacion += archivo.getName();
        //String nombreDeArchivoCompleto="/"+ archivo.getName(); //esto se puede recibir por parametro: String ubicacion

        try {
            inputStream = new FileInputStream(archivo); //abro un canal de datos input

            if (existeArchivoEnDropbox(ubicacion)){
                eliminarArchivoEnDropbox(ubicacion); // si el archivo existe lo piso(Esto es para los qr)
            }

            UploadBuilder uploadBuilder = cliente.files().uploadBuilder(ubicacion);//guardar el archivo en la carpeta DropBox
            uploadBuilder.withClientModified(new Date(archivo.lastModified()));//carga la fecha de la ultima modificacion
            uploadBuilder.withMode(WriteMode.ADD);// elige el modo de acceso en que se va a utilizar el archivo
            uploadBuilder.withAutorename(false);// Si hay un archivo del mismo nombre, crea otro con un (x) por ejemplo PDF(1)

            uploadBuilder.uploadAndFinish(inputStream); //se sube el archivo

            inputStream.close(); //cierro la entrada del archivo

        } catch (FileNotFoundException e) {
            //archivo no encontrado
            throw new FileNotFoundException("No se encontro el archivo");
        } catch (GetMetadataErrorException e) {
            //error con obtener info de un archivo dropbox
            e.getMessage();
        }
        catch (DbxException e) {
            //error con obtener info cuenta dropbox
          throw new DbxException("Error con dropbox");
        } catch (IOException e) {
            //error con el input/output (Archivo)
            e.getMessage();
        }

    }

    public String descargarArchivoDeDropbox(File archivo){

        String rutaLocal="FitAdmin/"+archivo.getName()+".jpg";


        String rutaDropbox="/fotosDePerfil/"+archivo.getName()+".jpg";
        System.out.println(archivo.getName());

        try{

            OutputStream canalDeDatos= new FileOutputStream(rutaLocal); // donde quiero que se me descargue

            FileMetadata metadata = cliente.files().downloadBuilder(rutaDropbox).download(canalDeDatos);


            canalDeDatos.close();

        }catch (DownloadErrorException e){
            e.printStackTrace();
            System.out.println("NO SE ENCONTRO EL ARCHYIVO");
        }
        catch (DbxException e) {
            System.err.println("Error al descargar el archivo: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return rutaLocal;
    }


    public String obtenerURL(String nombreArchivoDeDropbox)throws DbxException{
        //obtengo la url de Dropbox del archivo requerido

        //recordar subir solo el nombre del archivo que esta en dropbox

        //hay que especificar el tipo de archivo que quiero. EJ: /rutina.pdf
        //se construye dentro de este metodo

        String urlObtenida;
        String s="/"; //agrego la barra para el directorio de dropbox
        s= s.concat(nombreArchivoDeDropbox); //le concateno el nombre del archivo; como se llama en dropbox
        s= s.concat(".pdf"); // le agrego el tipo de archivo


        try {
            urlObtenida= cliente.files().getTemporaryLink(s).getLink();
        } catch (DbxException e) {
            throw new DbxException("Error en DB");
        }
        return urlObtenida;
    }

    private boolean existeArchivoEnDropbox(String nombreArchivo) throws DbxException {
        boolean flag=false;

        try {
            cliente.files().getMetadata(nombreArchivo); //obtengo la informacion del archivo y basicamente si la obtengo es porque existe
            flag=true;
        } catch (GetMetadataErrorException e) {
            if (e.errorValue.isPath() && e.errorValue.getPathValue().isNotFound()) {
                //si me tira una excepcion significa que no existe por lo tanto retorno false
                //flag=false;
            } else {
                throw e; //sino tiro el error
            }
        } catch (Exception e) {
            throw e; //si me tira otro tipo de excepcion, tambien retorno false ya que no existe
        }
        return flag;
    }

    public void eliminarArchivoEnDropbox(String nombreArchivo) throws DbxException {
        try {
            //si el archivo existe, lo elimino
            cliente.files().deleteV2(nombreArchivo).getMetadata();
        }catch (DbxException e)
        {
            // sino retorno una excepcion
            throw e;
        }
    }

}








