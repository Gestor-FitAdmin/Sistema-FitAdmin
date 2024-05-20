package org.example.API;


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.WriteMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


public class DropBoxAPI {
    private String ACCESS_TOKEN = "sl.B1lu8tfr3cgsRgoodZJrISND9Jm-DXloTLrHPAjMS8s1M9QqCk_bB3ln5yGxlTwdOrWEFm8ItAwRk4ICDNRZHC1spbfSFU4vCgXw3D8ZXGzzHFBso_N--AtxGJArZ-GkQ7lOEavgNjSwMNOm0hzC3Ys";
    private String CARPETA = "Aplicaciones/fitAdmin"; // Ruta de la carpeta en Dropbox
    private DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/fitAdmin").build();
    private DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

    //todo: verificar como subir el ACCESS TOKEN A GH

   public void subirPDF() throws IOException, DbxException {

        File pdf = new File("C:/Users/Gc/Dropbox/cv.pdf");// obtiene la url del pdf que quiero subir
        InputStream inputStream = new FileInputStream(pdf);// crea una entrada del archivo PDF

        UploadBuilder uploadBuilder = client.files().uploadBuilder("/pdf " + pdf.getName());//guardar el archivo en la carpeta DropBox
        uploadBuilder.withClientModified(new Date(pdf.lastModified()));//carga la fecha de la ultima modificacion
        uploadBuilder.withMode(WriteMode.ADD);// elige el modo de acceso en que se va a utilizar el archivo
        uploadBuilder.withAutorename(false);// Si hay un archivo del mismo nombre, crea otro con un (x) por ejemplo PDF(1)

        uploadBuilder.uploadAndFinish(inputStream);//se sube el archivo

        inputStream.close();
    }

    public String obtenerURL(String rutaRutina){
        //obtengo la url de Dropbox del archivo requerido
        //hay que especificar el tipo de archivo que quiero. EJ: rutina.pdf
        String s="/";
        s= s.concat(rutaRutina);

        try {
            return client.files().getTemporaryLink(s).getLink();
        } catch (DbxException e) {
            throw new RuntimeException(e);
        }

    }
}



