package org.example.GUI;


import org.example.Enum.EDiasSemana;
import org.example.Enum.EObjetivo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Rutina;

import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
        BotonRealizarBusquedaCliente = new JButton();
        BotonIrAtras = new JButton();
       JButton BotonEnviarRutina = new JButton();
       JTextField TextAreaBusqueda = new JTextField();

        jMenu1.setText("jMenu1");

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        BuscarCliente.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BuscarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 500));

        jPanel1.setBackground(new Color(63, 63, 63));
        jPanel1.setPreferredSize(new Dimension(900, 500));

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
        BotonArchivarCliente.setText("Archivar/Desarchivar");
        BotonArchivarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonArchivarClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBackground(new Color(242, 242, 242));
        TablaClientes.setBorder(new LineBorder(new Color(130, 130, 130), 1, true));
        TablaClientes.setModel(new DefaultTableModel(
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
                    Integer.class, String.class, Object.class, Object.class, Object.class, Object.class
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
        TablaClientes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
            TablaClientes.getColumnModel().getColumn(4).setResizable(false);
            TablaClientes.getColumnModel().getColumn(5).setResizable(false);
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
        BuscarClienteMenu.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Por ID", "Por Nombre", "Por Apellido", "Por Actividad", "Por Sexo", " " }));
        BuscarClienteMenu.setBorder(BorderFactory.createTitledBorder(null, "Buscar Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 14), new Color(242, 242, 242))); // NOI18N
        BuscarClienteMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BuscarClienteMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarClienteMenuActionPerformed(evt);
            }
        });

        BotonRealizarBusquedaCliente.setBackground(new Color(130, 130, 130));
        BotonRealizarBusquedaCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonRealizarBusquedaCliente.setForeground(new Color(242, 242, 242));
        BotonRealizarBusquedaCliente.setText("Buscar");
        BotonRealizarBusquedaCliente.setPreferredSize(new Dimension(130, 40));
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

        BotonEnviarRutina.setBackground(new Color(130, 130, 130));
        BotonEnviarRutina.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonEnviarRutina.setForeground(new Color(242, 242, 242));
        BotonEnviarRutina.setText("Enviar Rutina");
        BotonEnviarRutina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonEnviarRutinaActionPerformed(evt);
            }
        });

        TextAreaBusqueda.setBackground(new Color(130, 130, 130));
        TextAreaBusqueda.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        TextAreaBusqueda.setPreferredSize(new Dimension(202, 53));
        TextAreaBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextAreaBusquedaActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(BotonoCrearNuevoCliente, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(281, 281, 281)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonRealizarBusquedaCliente, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(BuscarClienteMenu, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextAreaBusqueda, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(BotonEnviarRutina, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(BotonAsignarRutina, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(BotonArchivarCliente, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(BotonIrAtras))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 860, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonoCrearNuevoCliente, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(BuscarClienteMenu, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(BotonRealizarBusquedaCliente, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BotonEnviarRutina, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonAsignarRutina, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonArchivarCliente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(BotonIrAtras)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void BotonEnviarRutinaActionPerformed(ActionEvent evt)
    {
        Gimnasio gym = GUIEnvoltorio.getGimnasio();//llamo a todo el gimnasio
        Integer idSocioAux;
        Integer filaSeleccionada = TablaClientes.getSelectedRow();
         if (filaSeleccionada != -1)//si  selecciono una fila correctamente
        {

            idSocioAux = (Integer) TablaClientes.getValueAt(filaSeleccionada, 0);//Fila que selecciona el usuario, la comlumna 0 que es el ID
            if (idSocioAux != null)//si el id es seleccionado
            {
                Cliente cliente = gym.buscar(idSocioAux);//agarro el cliente



                gym.crearUnPDFConUnaRutina(cliente);//le genero el PDF con la rutina
                try
                {
                    gym.enviarUnMail(cliente.geteMail(),"Rutina semanal",true);//le envio la rutina de los dias que tenga grabados
                } catch (MessagingException e)
                {
                    e.getMessage();
                } catch (MailSinArrobaE e)
                {
                    e.getMessage();
                }
            }
            else
            {
                JfrErrorPopUp errorPopUp = new JfrErrorPopUp("Busque un cliente para enviar la rutina");//si no selecciona nada es null por lo que necesito seleccione
            }


        } else
        {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("Seleccione un cliente");//si no selecciona nada es null por lo que necesito seleccione
        }
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





