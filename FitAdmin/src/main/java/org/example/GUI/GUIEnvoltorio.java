package org.example.GUI;

import org.example.Modelo.Gimnasio;

public class GUIEnvoltorio
{
    //atributos
    public static Gimnasio gimnasio;
    private JfrLogIn logIn;
    private JfrMenuPrincipal menuPrincipal;
    private JfrCliente cliente;
    private JfrAgregarNuevoCliente agregarNuevoCliente;
    private  JfrGenerarRutina generarRutina;
    private JfrAcceso acceso;

    //constructor

    public GUIEnvoltorio()
    {
        logIn = new JfrLogIn();
    }
    //metodos
    public void iniciarPrograma()
    {
        logIn.setVisible(true);
    }

    public static Gimnasio getGimnasio() {
        if (gimnasio == null)
        {
            gimnasio = new Gimnasio("fitAdmin", "Villa urquiza", "gonza", "1234");

        }
        return gimnasio;
    }
}
