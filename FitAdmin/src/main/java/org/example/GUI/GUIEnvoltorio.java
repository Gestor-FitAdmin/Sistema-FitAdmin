package org.example.GUI;

import org.example.Modelo.Gimnasio;

public class GUIEnvoltorio
{
    //atributos
    private Gimnasio gimnasio;
    private JfrLogIn logIn;
    private JfrMenuPrincipal menuPrincipal;
    private JfrCliente cliente;
    private JfrAgregarNuevoCliente agregarNuevoCliente;
    private  JfrGenerarRutina generarRutina;
    private JfrAcceso acceso;

    //constructor

    public GUIEnvoltorio(Gimnasio gimnasio)
    {
        this.gimnasio = gimnasio;
        logIn = new JfrLogIn(gimnasio);
    }
    //metodos
    public void iniciarPrograma()
    {
        logIn.setVisible(true);
    }

}
