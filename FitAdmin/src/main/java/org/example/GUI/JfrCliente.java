package org.example.GUI;


import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrCliente extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton BotonArchivarCliente;
    private javax.swing.JButton BotonAsignarRutina;
    private javax.swing.JButton BotonIrAtras;
    private javax.swing.JButton BotonRealizarBusquedaCliente;
    private javax.swing.JButton BotonoCrearNuevoCliente;
    private javax.swing.JComboBox<String> BuscarCliente;
    private javax.swing.JComboBox<String> BuscarClienteMenu;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTextField TextBoxClienteBusqueda;
    private java.awt.Choice choice1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    /**
     * Creates new form Clientes
     */
    public JfrCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        choice1 = new java.awt.Choice();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        BuscarCliente = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonoCrearNuevoCliente = new javax.swing.JButton();
        BotonArchivarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        BotonAsignarRutina = new javax.swing.JButton();
        BuscarClienteMenu = new javax.swing.JComboBox<>();
        TextBoxClienteBusqueda = new javax.swing.JTextField();
        BotonRealizarBusquedaCliente = new javax.swing.JButton();
        BotonIrAtras = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        BuscarCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        BotonoCrearNuevoCliente.setBackground(new java.awt.Color(130, 130, 130));
        BotonoCrearNuevoCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonoCrearNuevoCliente.setForeground(new java.awt.Color(242, 242, 242));
        BotonoCrearNuevoCliente.setText("Agregar Nuevo Cliente");
        BotonoCrearNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonoCrearNuevoClienteActionPerformed(evt);
            }
        });

        BotonArchivarCliente.setBackground(new java.awt.Color(130, 130, 130));
        BotonArchivarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonArchivarCliente.setForeground(new java.awt.Color(242, 242, 242));
        BotonArchivarCliente.setText("Archivar Cliente");
        BotonArchivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonArchivarClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBackground(new java.awt.Color(242, 242, 242));
        TablaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(130, 130, 130), 1, true));
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "IdSocio", "Nombre", "Apellido"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TablaClientes.setToolTipText("");
        TablaClientes.setColumnSelectionAllowed(true);
        TablaClientes.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        BotonAsignarRutina.setBackground(new java.awt.Color(130, 130, 130));
        BotonAsignarRutina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonAsignarRutina.setForeground(new java.awt.Color(242, 242, 242));
        BotonAsignarRutina.setText("Asignar Rutina");
        BotonAsignarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAsignarRutinaActionPerformed(evt);
            }
        });

        BuscarClienteMenu.setBackground(new java.awt.Color(130, 130, 130));
        BuscarClienteMenu.setForeground(new java.awt.Color(242, 242, 242));
        BuscarClienteMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Todos", "Por ID", "Por Nombre", "Por Apellido", "Por Actividad", "Por Sexo"}));
        BuscarClienteMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(242, 242, 242))); // NOI18N
        BuscarClienteMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarClienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteMenuActionPerformed(evt);
            }
        });

        TextBoxClienteBusqueda.setBackground(new java.awt.Color(130, 130, 130));
        TextBoxClienteBusqueda.setForeground(new java.awt.Color(242, 242, 242));
        TextBoxClienteBusqueda.setToolTipText("");
        TextBoxClienteBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 1, true));
        TextBoxClienteBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TextBoxClienteBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxClienteBusquedaActionPerformed(evt);
            }
        });

        BotonRealizarBusquedaCliente.setBackground(new java.awt.Color(130, 130, 130));
        BotonRealizarBusquedaCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonRealizarBusquedaCliente.setForeground(new java.awt.Color(242, 242, 242));
        BotonRealizarBusquedaCliente.setText("Buscar");
        BotonRealizarBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRealizarBusquedaClienteActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new java.awt.Color(63, 63, 63));
        BotonIrAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setBorder(null);
        BotonIrAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(47, 47, 47))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(BuscarClienteMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TextBoxClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(BotonIrAtras)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BuscarClienteMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(TextBoxClienteBusqueda))
                                .addGap(18, 18, 18)
                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(95, 95, 95))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(BotonIrAtras)
                                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    //botones

    private void BotonArchivarClienteActionPerformed(java.awt.event.ActionEvent evt) {

        int posFila =TablaClientes.getSelectedRow(); // posicion fila socio
        int posColumna=0; // id del socio

        if (posFila != -1)
        {

            DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel(); // datos de toda la fila
            Integer idSocio=(Integer) modelo.getValueAt(posFila,posColumna);

            Cliente clienteElegido= GUIEnvoltorio.getGimnasio().buscar(idSocio);

            if (clienteElegido.isEstado()) {
                //con el mismo boton
                clienteElegido.setEstado(false);
            }
            else{
                clienteElegido.setEstado(true);
            }
        }
        else
        {
            JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No selecciono ningun cliente");
        }

    }

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void BotonAsignarRutinaActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        JfrGenerarRutina rut = new JfrGenerarRutina();
        rut.setVisible(true);
    }

    private void BuscarClienteMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //obtengo la opcion del usuario y traigo todos los valores que quiere




    }

    private void BotonRealizarBusquedaClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        //muestro lo obtenido de la busqueda en la tabla

        String opcionElegida= (String) BuscarClienteMenu.getSelectedItem(); //obtengo el valor de la op q eligio el usuario

        assert opcionElegida != null; // aseguro que la variable opcionElegida no va a ser null
        opcionElegida= opcionElegida.toLowerCase();

        switch (opcionElegida)
        {
            case "todos":
                GUIEnvoltorio.getGimnasio().getClientes();
                break;
            case "por id":
                System.out.println("eligio por id");
                break;
            case "por nombre":
                break;
            case "por apellido":
                break;
            case "por actividad":
                break;
            case "por sexo":
                break;
            default:
                break;


    }

    private void TextBoxClienteBusquedaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void BotonoCrearNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        JfrAgregarNuevoCliente nuevo = new JfrAgregarNuevoCliente();
        nuevo.setVisible(true);


    }

    private void BotonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        JfrMenuPrincipal menu = new JfrMenuPrincipal();
        menu.setVisible(true);


    }


}





