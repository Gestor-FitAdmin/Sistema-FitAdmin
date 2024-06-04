package org.example.GUI;


import org.example.API.DropBoxAPI;
import org.example.GUI.PopUps.JfrAutenticacionPopUp;
import org.example.Modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrMenuPrincipal extends javax.swing.JFrame {

    // Variables declaration
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonEstadisticas;
    private javax.swing.JButton BotonIngresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    //private static boolean tokenEstaVerificado = false; //todo: verificar que no quede en blanco la pantalla


    public JfrMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        cargarTablaDeDatos();

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());




        if (!DropBoxAPI.verificarSiElTokenEsValido(DropBoxAPI.leerTokenDeAcceso()))
        {
            setVisible(true);
            JfrAutenticacionPopUp jfrAutenticacionPopUp= new JfrAutenticacionPopUp(this,true);
        }

        setVisible(true);

    }




    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        BotonClientes = new javax.swing.JButton();
        BotonEstadisticas = new javax.swing.JButton();
        BotonIngresos = new javax.swing.JButton();


        jMenu3.setText("jMenu3");
        jLabel2.setText("jLabel2");


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // No cerrar directamente

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                // Crear el panel de opciones con los botones personalizados
                Object[] options = {"Si", "No"};
                int option = JOptionPane.showOptionDialog(
                        JfrMenuPrincipal.this,
                        "¿Desea salir?",
                        "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (option == JOptionPane.YES_OPTION) {
                // Llamar al método de guardar cambios antes de cerrar
                    gimnasio.guardarClientesEnArchivo("clientes.bin");
                    System.exit(0);
                }
            }
        });

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setForeground(new java.awt.Color(63, 63, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "N° Socio", "Nombre", "Apellido", "Actividad", "Email", "DNI", "Peso", "Altura", "Sexo", "Cuota"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);
        if (tblDatos.getColumnModel().getColumnCount() > 0) {
            tblDatos.getColumnModel().getColumn(0).setResizable(true);
            tblDatos.getColumnModel().getColumn(1).setResizable(true);
            tblDatos.getColumnModel().getColumn(2).setResizable(true);
            tblDatos.getColumnModel().getColumn(3).setResizable(true);
            tblDatos.getColumnModel().getColumn(4).setResizable(true);
            tblDatos.getColumnModel().getColumn(5).setResizable(true);
            tblDatos.getColumnModel().getColumn(6).setResizable(true);
            tblDatos.getColumnModel().getColumn(7).setResizable(true);
            tblDatos.getColumnModel().getColumn(8).setResizable(true);
            tblDatos.getColumnModel().getColumn(9).setResizable(true);
        }



        BotonClientes.setBackground(new java.awt.Color(130, 130, 130));
        BotonClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonClientes.setForeground(new java.awt.Color(242, 242, 242));
        BotonClientes.setText("Clientes");
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });

        BotonEstadisticas.setBackground(new java.awt.Color(130, 130, 130));
        BotonEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonEstadisticas.setForeground(new java.awt.Color(242, 242, 242));
        BotonEstadisticas.setText("Estadísticas");
        BotonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEstadisticasActionPerformed(evt);
            }
        });

        BotonIngresos.setBackground(new java.awt.Color(130, 130, 130));
        BotonIngresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonIngresos.setForeground(new java.awt.Color(242, 242, 242));
        BotonIngresos.setText("Ingreso Cliente");
        BotonIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(BotonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(BotonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(BotonIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1)
                                                .addGap(281, 281, 281)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BotonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );



        pack();
    }// </editor-fold>

    private void BotonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrEstadisticas estadisticas = new JfrEstadisticas();
        estadisticas.setVisible(true);
    }

    private void BotonIngresosActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        JfrAcceso acce = new JfrAcceso();
        acce.setVisible(true);


    }

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);


    }

    private void cargarTablaDeDatos()
    {
        HashMap<Integer,Cliente> hashMapCliente = GUIEnvoltorio.getGimnasio().getClientes();
        Cliente clienteAux=null;
        int i=0;
        String actividesString="";


        ArrayList<Cliente> arrayListCliente= GUIEnvoltorio.getGimnasio().retornarListaDeClientes();
        for (Cliente cliente: arrayListCliente)
        {
            if (cliente.isEstado())
            {
                GUIEnvoltorio.agregarUnClienteEnTablaDeClientes((DefaultTableModel) tblDatos.getModel(),cliente);
            }
        }
        

    }


}


