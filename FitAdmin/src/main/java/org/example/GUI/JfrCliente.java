package org.example.GUI;


import org.example.Modelo.Cliente;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class JfrCliente extends JFrame {

    // Variables declaration - do not modify
    private JButton BotonArchivarCliente;
    private JButton BotonAsignarRutina;
    private JButton BotonIrAtras;
    private JButton BotonRealizarBusquedaCliente;
    private JButton BotonoCrearNuevoCliente;
    private JComboBox<String> BuscarCliente;
    private JComboBox<String> BuscarClienteMenu;
    private JTable TablaClientes;
    private JTextField TextBoxClienteBusqueda;
    private Choice choice1;
    private JLabel jLabel1;
    private JList<String> jList1;
    private JMenu jMenu1;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

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
        BotonRealizarBusquedaCliente = new javax.swing.JButton();
        BotonIrAtras = new javax.swing.JButton();
       JButton BotonEnviarRutina = new javax.swing.JButton();
       JTextField TextAreaBusqueda = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        BuscarCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

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
        BotonArchivarCliente.setText("Archivar/Desarchivar");
        BotonArchivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonArchivarClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBackground(new java.awt.Color(242, 242, 242));
        TablaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(130, 130, 130), 1, true));
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "N° Socio", "Nombre", "Apellido", "DNI", "Actividad", "Sexo"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.setToolTipText("");
        TablaClientes.setColumnSelectionAllowed(true);
        TablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
            TablaClientes.getColumnModel().getColumn(4).setResizable(false);
            TablaClientes.getColumnModel().getColumn(5).setResizable(false);
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
        BuscarClienteMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Por ID", "Por Nombre", "Por Apellido", "Por Actividad", "Por Sexo", " " }));
        BuscarClienteMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(242, 242, 242))); // NOI18N
        BuscarClienteMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarClienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteMenuActionPerformed(evt);
            }
        });

        BotonRealizarBusquedaCliente.setBackground(new java.awt.Color(130, 130, 130));
        BotonRealizarBusquedaCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonRealizarBusquedaCliente.setForeground(new java.awt.Color(242, 242, 242));
        BotonRealizarBusquedaCliente.setText("Buscar");
        BotonRealizarBusquedaCliente.setPreferredSize(new java.awt.Dimension(130, 40));
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

        BotonEnviarRutina.setBackground(new java.awt.Color(130, 130, 130));
        BotonEnviarRutina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonEnviarRutina.setForeground(new java.awt.Color(242, 242, 242));
        BotonEnviarRutina.setText("Enviar Rutina");
        BotonEnviarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarRutinaActionPerformed(evt);
            }
        });

        TextAreaBusqueda.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TextAreaBusqueda.setPreferredSize(new java.awt.Dimension(202, 53));
        TextAreaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(281, 281, 281)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(BuscarClienteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextAreaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(BotonEnviarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(BotonIrAtras))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BuscarClienteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BotonEnviarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(BotonIrAtras)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void BotonEnviarRutinaActionPerformed(ActionEvent evt) {
    }

    private void TextAreaBusquedaActionPerformed(ActionEvent evt) {
    }

    private void BotonAsignarRutina1ActionPerformed(ActionEvent evt) {
    }

    private void BotonArchivarClienteActionPerformed(ActionEvent evt) {
    }

    private void BuscarClienteActionPerformed(ActionEvent evt) {
    }

    private void BotonAsignarRutinaActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        JfrGenerarRutina rut = new JfrGenerarRutina();
        rut.setVisible(true);
    }

    private void BuscarClienteMenuActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BotonRealizarBusquedaClienteActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        //muestro lo obtenido de la busqueda en la tabla
        int i=0, auxInt=0;
        ArrayList<Cliente> arrayQueSeMostrara = new ArrayList<>();
        ArrayList<Cliente> todosLosClientes= GUIEnvoltorio.getGimnasio().retornarListaDeClientes();

        String opcionElegida = (String) BuscarClienteMenu.getSelectedItem(); //obtengo el valor de la op q eligio el usuario
        assert opcionElegida != null; // aseguro que la variable opcionElegida no va a ser null
        opcionElegida = opcionElegida.toLowerCase();

        String busqueda=TextBoxClienteBusqueda.getText(); //obtengo el valor de la caja de texto que hay

        busqueda= busqueda.replace(" ",""); //le saco todos los espacios

        switch (opcionElegida) {
            case "todos":
                arrayQueSeMostrara = todosLosClientes;
                break;
            case "por id":


                if (!busqueda.isEmpty()) //si no contiene nada o si no hay espacios, tiene que haber un numero si o si
                {
                    //el parseo del string a Integer puede provocar errores si no se verifica
                    if(GUIEnvoltorio.getGimnasio().verificarSiExisteClienteXId(Integer.parseInt(busqueda)))
                    {

                        arrayQueSeMostrara.add(GUIEnvoltorio.getGimnasio().buscar(Integer.parseInt(busqueda)));
                    }
                    else {
                        JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("El ID buscado no existe");
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No ingreso ningun ID");
                }

                break;
            case "por nombre":

                if (!busqueda.isEmpty()){

                    for (Cliente cliente: todosLosClientes)
                    {
                        if (cliente.getNombre().equalsIgnoreCase(busqueda))
                        {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if(arrayQueSeMostrara.isEmpty())
                    {
                        JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No se encontro el nombre buscado");
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No ingreso ningun nombre");
                }

                break;
            case "por apellido":
                if (!busqueda.isEmpty()){

                    for (Cliente cliente: todosLosClientes)
                    {
                        if (cliente.getApellido().equalsIgnoreCase(busqueda))
                        {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if(arrayQueSeMostrara.isEmpty())
                    {
                        JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No se encontro el apellido buscado");
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No ingreso ningun apellido");
                }
                break;
            case "por actividad":
                if (!busqueda.isEmpty()){
                    HashSet<String> actividadesDelCliente;

                    for (Cliente cliente: todosLosClientes)
                    {
                        //validar como hacer para que ignore las mayusculas o minusculas
                        actividadesDelCliente= cliente.getActividadesInscripto();
                        if (actividadesDelCliente.contains(busqueda.toLowerCase()))
                        {
                            arrayQueSeMostrara.add(cliente);
                        }

                    }
                    if(arrayQueSeMostrara.isEmpty())
                    {
                        JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No se encontro la actividad buscada");
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No ingreso ninguna actividad");
                }


                break;
            case "por sexo":

                if (!busqueda.isEmpty()){

                    for (Cliente cliente: todosLosClientes)
                    {
                        if (cliente.getSexo().equalsIgnoreCase(busqueda))
                        {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if(arrayQueSeMostrara.isEmpty())
                    {
                        JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No hay ninguna persona del sexo elegido");
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("No ingreso ningun sexo");
                }
                break;
            default:
                arrayQueSeMostrara = GUIEnvoltorio.getGimnasio().retornarListaDeClientes();
                break;
        }
        for (Cliente cliente: arrayQueSeMostrara) //id nombre apellido
        {
            TablaClientes.setValueAt(cliente.getIdCliente(),i,0);
            TablaClientes.setValueAt(cliente.getNombre(),i,1);
            TablaClientes.setValueAt(cliente.getApellido(),i,2);
            TablaClientes.setValueAt(cliente.getDNI(),i,3);
            TablaClientes.setValueAt(cliente.getActividadesInscripto(),i,4);
            TablaClientes.setValueAt(cliente.getSexo(),i,5);

            i++;
        }


    }
    private void TextBoxClienteBusquedaActionPerformed(ActionEvent evt) {

    }

    private void BotonoCrearNuevoClienteActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        JfrAgregarNuevoCliente nuevo = new JfrAgregarNuevoCliente();
        nuevo.setVisible(true);


    }

    private void BotonIrAtrasActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        JfrMenuPrincipal menu = new JfrMenuPrincipal();
        menu.setVisible(true);


    }


}





