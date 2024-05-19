package org.example.API;


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


public class DropBoxAPI {
    private static final String ACCESS_TOKEN = "";
    private static final String CARPETA = "Aplicaciones/fitAdmin"; // Ruta de la carpeta en Dropbox
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

    public void ss() throws DbxException {
        System.out.println(client.users().getCurrentAccount().getEmail());
    }

   public void verPDF() throws IOException, DbxException {

        File pdf = new File("C:/Users/Gc/Dropbox/cv.pdf");// obtiene la url del pdf que quiero subir
        InputStream inputStream = new FileInputStream(pdf);// crea una entrada del archivo PDF

        UploadBuilder uploadBuilder = client.files().uploadBuilder("/pdf " + pdf.getName());//guardar el archivo en la carpeta DropBox
        uploadBuilder.withClientModified(new Date(pdf.lastModified()));//carga la fecha de la ultima modificacion
        uploadBuilder.withMode(WriteMode.ADD);// elige el modo de acceso en que se va a utilizar el archivo
        uploadBuilder.withAutorename(true);// Si hay un archivo del mismo nombre, crea otro con un (x) por ejemplo PDF(1)

        uploadBuilder.uploadAndFinish(inputStream);//se sube el archivo

        inputStream.close();
    }

    public void descargarURL() throws DbxException {
        try {
            // Crear un enlace compartido
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings(CARPETA);
            String sharedUrl = sharedLinkMetadata.getUrl();
            System.out.println("Enlace compartido: " + sharedUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener el enlace compartido: " + e.getMessage());
        }


    }
}



