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
    public void generarQr(String url) {
        String ruta="qrs-Generados/qrCliente.jpg";
        BitMatrix matrix= null;
        try {
            matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,500,500);
            MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get(ruta));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("QR generado correctamente");

    }


}
