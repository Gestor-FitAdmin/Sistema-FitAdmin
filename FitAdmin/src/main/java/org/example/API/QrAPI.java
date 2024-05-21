package org.example.API;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.kernel.geom.Matrix;

import java.io.IOException;
import java.nio.file.Paths;

public class QrAPI {
    //atributos

    //constructor

    //metodos
    public void generarQr(String urlDeDropbox) {
        String ruta="qrs-Generados/qrCliente.jpg"; //ruta donde voy a guardar el QR
        BitMatrix matrix;
        try {
            matrix = new MultiFormatWriter().encode(urlDeDropbox, BarcodeFormat.QR_CODE,500,500); // le doy formato al QR: le paso el url, formato QR, y el tamanio
            MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get(ruta)); // creo el archivo QR en formato jpg en la ruta especificada
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("QR generado correctamente");

    }


}
