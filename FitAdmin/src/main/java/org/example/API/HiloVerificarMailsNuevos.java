package org.example.API;

import org.example.GUI.GUIEnvoltorio;
import org.example.Modelo.Gimnasio;

public class HiloVerificarMailsNuevos implements Runnable {

    //atributos
    private Gimnasio gimnasio;
    private boolean corriendo;
    //constructores
    public HiloVerificarMailsNuevos(Gimnasio gimnasio)
    {
        this.gimnasio=gimnasio;
        corriendo=false;
    }

    @Override
    public void run() {
        corriendo=true;
        gimnasio.leerMails();
        Thread listenerThread = new Thread();
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void parar()
    {
        this.corriendo=false;
    }
}
