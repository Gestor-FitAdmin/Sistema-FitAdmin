package org.example.GUI;


import org.example.Modelo.Actividad;
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

        jMenu1 = new JMenu();
        choice1 = new Choice();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        BuscarCliente = new JComboBox<>();
        jProgressBar1 = new JProgressBar();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        BotonoCrearNuevoCliente = new JButton();
        BotonArchivarCliente = new JButton();
        jScrollPane2 = new JScrollPane();
        TablaClientes = new JTable();
        BotonAsignarRutina = new JButton();
        BuscarClienteMenu = new JComboBox<>();
        TextBoxClienteBusqueda = new JTextField();
        BotonRealizarBusquedaCliente = new JButton();
        BotonIrAtras = new JButton();

        jMenu1.setText("jMenu1");

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        BuscarCliente.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        BuscarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(63, 63, 63));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        BotonoCrearNuevoCliente.setBackground(new Color(130, 130, 130));
        BotonoCrearNuevoCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonoCrearNuevoCliente.setForeground(new Color(242, 242, 242));
        BotonoCrearNuevoCliente.setText("Agregar Nuevo Cliente");
        BotonoCrearNuevoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonoCrearNuevoClienteActionPerformed(evt);
            }
        });

        BotonArchivarCliente.setBackground(new Color(130, 130, 130));
        BotonArchivarCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonArchivarCliente.setForeground(new Color(242, 242, 242));
        BotonArchivarCliente.setText("Archivar Cliente");
        BotonArchivarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonArchivarClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBackground(new Color(242, 242, 242));
        TablaClientes.setBorder(new LineBorder(new Color(130, 130, 130), 1, true));
        TablaClientes.setModel(new DefaultTableModel(
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
                    Integer.class, String.class, Object.class
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
        TablaClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
        }

        BotonAsignarRutina.setBackground(new Color(130, 130, 130));
        BotonAsignarRutina.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonAsignarRutina.setForeground(new Color(242, 242, 242));
        BotonAsignarRutina.setText("Asignar Rutina");
        BotonAsignarRutina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonAsignarRutinaActionPerformed(evt);
            }
        });

        BuscarClienteMenu.setBackground(new Color(130, 130, 130));
        BuscarClienteMenu.setForeground(new Color(242, 242, 242));
        BuscarClienteMenu.setModel(new DefaultComboBoxModel<>(new String[]{"Todos", "Por ID", "Por Nombre", "Por Apellido", "Por Actividad", "Por Sexo"}));
        BuscarClienteMenu.setBorder(BorderFactory.createTitledBorder(null, "Buscar Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 14), new Color(242, 242, 242))); // NOI18N
        BuscarClienteMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BuscarClienteMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarClienteMenuActionPerformed(evt);
            }
        });

        TextBoxClienteBusqueda.setBackground(new Color(130, 130, 130));
        TextBoxClienteBusqueda.setForeground(new Color(242, 242, 242));
        TextBoxClienteBusqueda.setToolTipText("");
        TextBoxClienteBusqueda.setBorder(new LineBorder(new Color(242, 242, 242), 1, true));
        TextBoxClienteBusqueda.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        TextBoxClienteBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextBoxClienteBusquedaActionPerformed(evt);
            }
        });

        BotonRealizarBusquedaCliente.setBackground(new Color(130, 130, 130));
        BotonRealizarBusquedaCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonRealizarBusquedaCliente.setForeground(new Color(242, 242, 242));
        BotonRealizarBusquedaCliente.setText("Buscar");
        BotonRealizarBusquedaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonRealizarBusquedaClienteActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new Color(63, 63, 63));
        BotonIrAtras.setIcon(new ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setBorder(null);
        BotonIrAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIrAtrasActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(BotonoCrearNuevoCliente, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                                                .addGap(47, 47, 47))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(BuscarClienteMenu, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TextBoxClienteBusqueda, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(BotonIrAtras)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(BotonAsignarRutina, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(BotonArchivarCliente, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(BotonRealizarBusquedaCliente, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(BotonoCrearNuevoCliente, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BuscarClienteMenu, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(TextBoxClienteBusqueda))
                                .addGap(18, 18, 18)
                                .addComponent(BotonRealizarBusquedaCliente, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addGap(95, 95, 95))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(BotonAsignarRutina, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BotonArchivarCliente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(BotonIrAtras)
                                .addGap(14, 14, 14))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    //botones

    private void BotonArchivarClienteActionPerformed(ActionEvent evt) {

        int posFila =TablaClientes.getSelectedRow(); // posicion fila socio
        int posColumna=0; // id del socio
        Cliente clienteElegido = null;
        if (posFila != -1)
        {

            DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel(); // datos de toda la fila
            Integer idSocio=(Integer) modelo.getValueAt(posFila,posColumna);

            clienteElegido = GUIEnvoltorio.getGimnasio().buscar(idSocio);

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
            TablaClientes.setValueAt(cliente.getIdSocio(),i,0);
            TablaClientes.setValueAt(cliente.getNombre(),i,1);
            TablaClientes.setValueAt(cliente.getApellido(),i,2);

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





