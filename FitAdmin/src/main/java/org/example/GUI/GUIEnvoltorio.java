package org.example.GUI;

import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

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
            gimnasio.leerArchivoCliente("clientes.bin");

        }
        return gimnasio;
    }

    public static void limpiarTabla(DefaultTableModel defaultTableModel) {
        defaultTableModel.setRowCount(0);
    }

    public static void agregarUnArrayDeClientesEnTablaDeClientes(DefaultTableModel defaultTableModel, ArrayList<Cliente> clienteArrayList, boolean opcion) {
        if(opcion) {
            for (Cliente cliente : clienteArrayList) {
                agregarUnClienteEnTablaDeClientes(defaultTableModel, cliente);
            }
        }
        else{
            for(Cliente cliente : clienteArrayList) {
                agregarUnClienteEnTablaDeClientesCorto(defaultTableModel, cliente);
            }
            }
    }

    public static  void agregarUnClienteEnTablaDeClientesCorto(DefaultTableModel defaultTableModel, Cliente unCliente){
        String[] datosCliente = new String[]{String.valueOf(unCliente.getIdCliente()), unCliente.getNombre(), unCliente.getApellido(),unCliente.getDNI(), unCliente.listarActividades(), String.valueOf(unCliente.getSexo()), String.valueOf(unCliente.isEstado())};

        defaultTableModel.addRow(datosCliente);

    }

    public static void agregarUnClienteEnTablaDeClientes(DefaultTableModel defaultTableModel, Cliente unCliente) {
        String[] datosCliente = new String[]{String.valueOf(unCliente.getIdCliente()), unCliente.getNombre(), unCliente.getApellido(), unCliente.listarActividades(), unCliente.geteMail(),unCliente.getDNI(), unCliente.getPeso().toString(), unCliente.getAltura().toString(), String.valueOf(unCliente.getSexo()), String.valueOf(unCliente.isCuotaPagada())};

        defaultTableModel.addRow(datosCliente);
    }

}
