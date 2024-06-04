package org.example.API;

import org.example.Modelo.Gimnasio;

public class TareaVerificarMailsNuevos implements Runnable {

    //atributos
    private Gimnasio gimnasio;
    private boolean corriendo;
    //constructores
    public TareaVerificarMailsNuevos(Gimnasio gimnasio)
    {
        this.gimnasio=gimnasio;
        corriendo=false;
    }

    @Override
    public void run() {
        corriendo=true;
        gimnasio.leerMails();
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void parar()
    {
        this.corriendo=false;
    }
}
