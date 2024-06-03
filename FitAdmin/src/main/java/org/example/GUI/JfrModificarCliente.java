package org.example.GUI;

import org.example.GUI.PopUps.JfrAvisoPopUp;
import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.Modelo.Cliente;
import org.example.Modelo.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrModificarCliente extends JFrame {


    private JButton BotonGuardarCambios;
    private JButton BotonIrAtras;
    private JComboBox<String> ComboBoxModificar;
    private JTable TablaClienteAModificar;
    private JTextField TextFieldModificar;
    private JToggleButton ToggleButtonPagar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private Cliente cliente;


    public JfrModificarCliente(Cliente p_cliente) {
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());
        cliente = p_cliente;
        agregarClienteSeleccionadoATabla();
    }

    private void initComponents() {


        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        TablaClienteAModificar = new JTable();
        ComboBoxModificar = new JComboBox<>();
        jLabel2 = new JLabel();
        TextFieldModificar = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        ToggleButtonPagar = new JToggleButton();
        BotonGuardarCambios = new JButton();
        BotonIrAtras = new JButton();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // No cerrar directamente

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                // Crear el panel de opciones con los botones personalizados
                Object[] options = {"Si", "No"};
                int option = JOptionPane.showOptionDialog(
                        JfrModificarCliente.this,
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
        jPanel1.setBackground(new Color(63, 63, 63));
        jPanel1.setPreferredSize(new Dimension(750, 500));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        TablaClienteAModificar.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "N° Socio", "Nombre", "Apellido", "Actividad", "E-Mail", "DNI", "Peso", "Altura", "Sexo", "Cuota"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaClienteAModificar);
        if (TablaClienteAModificar.getColumnModel().getColumnCount() > 0) {
            TablaClienteAModificar.getColumnModel().getColumn(0).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(1).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(2).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(3).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(4).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(5).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(6).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(7).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(8).setResizable(false);
            TablaClienteAModificar.getColumnModel().getColumn(9).setResizable(false);
        }


        ComboBoxModificar.setBackground(new Color(130, 130, 130));
        ComboBoxModificar.setForeground(new Color(242, 242, 242));
        ComboBoxModificar.setModel(new DefaultComboBoxModel<>(new String[]{"Nombre", "Apellido", "E-Mail", "DNI", "Peso", "Altura"}));
        ComboBoxModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ComboBoxModificarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new Color(242, 242, 242));
        jLabel2.setText("Modificar : ");

        TextFieldModificar.setBackground(new Color(130, 130, 130));
        TextFieldModificar.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        TextFieldModificar.setForeground(new Color(242, 242, 242));
        TextFieldModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextFieldModificarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new Color(242, 242, 242));
        jLabel3.setText("Nuevo Dato : ");

        jLabel4.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(242, 242, 242));
        jLabel4.setText("Cuota");

        ToggleButtonPagar.setBackground(new Color(130, 130, 130));
        ToggleButtonPagar.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ToggleButtonPagar.setForeground(new Color(242, 242, 242));
        ToggleButtonPagar.setText("Pagar");
        ToggleButtonPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ToggleButtonPagarActionPerformed(evt);
            }
        });

        BotonGuardarCambios.setBackground(new Color(130, 130, 130));
        BotonGuardarCambios.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonGuardarCambios.setForeground(new Color(242, 242, 242));
        BotonGuardarCambios.setText("Guardar Cambio");
        BotonGuardarCambios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonGuardarCambiosActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new Color(63, 63, 63));
        BotonIrAtras.setIcon(new ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setToolTipText("");
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(238, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(220, 220, 220))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(TextFieldModificar)
                                                                        .addComponent(ComboBoxModificar, 0, 148, Short.MAX_VALUE)
                                                                        .addComponent(ToggleButtonPagar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(230, 230, 230))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BotonGuardarCambios, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(251, 251, 251))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BotonIrAtras)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ComboBoxModificar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextFieldModificar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(ToggleButtonPagar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(BotonGuardarCambios, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(BotonIrAtras)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void ToggleButtonPagarActionPerformed(ActionEvent evt) {

        if (ToggleButtonPagar.isSelected()) {
            ToggleButtonPagar.setText("Pagar");
            cliente.modificarCuotaCliente();
        } else {
            ToggleButtonPagar.setText("Pagado");
            cliente.modificarCuotaCliente();
        }
        agregarClienteSeleccionadoATabla();
    }

    private void ComboBoxModificarActionPerformed(ActionEvent evt) {

            TextFieldModificar.setText("");
    }

    private void BotonGuardarCambiosActionPerformed(ActionEvent evt) {
        JfrAgregarNuevoCliente nuevoCliente = new JfrAgregarNuevoCliente();

        String opcionElegida = (String) ComboBoxModificar.getSelectedItem();
        String busqueda = TextFieldModificar.getText().trim();

        switch (opcionElegida) {
            case "Nombre": {

                if(!busqueda.isEmpty()) {
                    if(!nuevoCliente.verificarSiContieneNumero(busqueda)) {
                        cliente.modificarNombreCliente(busqueda);
                        agregarClienteSeleccionadoATabla();
                    }
                    else {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this,true, "El nombre no puede tener digitos");
                    }
                }
                else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun nombre");
                    }
                break;
            }

            case "Apellido": {
                if(!busqueda.isEmpty()) {
                    if(!nuevoCliente.verificarSiContieneNumero(busqueda)) {
                        cliente.modificarApellidoCliente(busqueda);
                        agregarClienteSeleccionadoATabla();
                    }else{
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "El apellido no puede contener digitos");
                    }
                }else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun Apellido");
                }
                break;
            }
            case "DNI" : {
                if(!busqueda.isEmpty()) {
                    if(!GUIEnvoltorio.getGimnasio().verificarDNIExistente(busqueda) && !nuevoCliente.verificarTamDNI(busqueda)){

                    cliente.modificarDNICliente(busqueda);
                    agregarClienteSeleccionadoATabla();
                    } else{
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Ingrese un DNI valido");
                    }
                }else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun DNI");
                }
                break;
            }
            case "E-Mail" : {
                if(!busqueda.isEmpty()) {
                    if(!nuevoCliente.verificarArroba(busqueda)){
                        cliente.modificarEMailCliente(busqueda);
                        agregarClienteSeleccionadoATabla();

                    }else {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Debe ingresar un mail con '@' ");
                    }
                }else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun E-Mail");
                }
                break;
            }
            case "Peso" : {
                if(!busqueda.isEmpty()) {
                    try {
                        Double dato = Double.parseDouble(busqueda);
                        cliente.modificarPesoCliente(dato);
                        agregarClienteSeleccionadoATabla();

                    }catch (NumberFormatException e){
                        JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "Ingrese un dato valido");
                    }
                }else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun peso");
                }
                break;
            }
            case "Altura" : {
                if(!busqueda.isEmpty()) {
                    try {
                        Double dato = Double.parseDouble(busqueda);
                        cliente.modificarAlturaCliente(dato);
                        agregarClienteSeleccionadoATabla();
                    }catch (NumberFormatException e){
                        JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "Ingrese un dato valido");
                    }

                }else{
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ninguna altura");
                }
                break;
            }

            default:
                JfrAvisoPopUp aviso = new JfrAvisoPopUp(this,true,"Selecciona una opcion");
        }


        TextFieldModificar.setText("");
    }

    private void TextFieldModificarActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void BotonIrAtrasActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);

    }

    private void agregarClienteSeleccionadoATabla() {
        TableModel table = TablaClienteAModificar.getModel();
        TablaClienteAModificar.setModel(table);

        TablaClienteAModificar.setValueAt(cliente.getIdCliente(), 0, 0);
        table.setValueAt(cliente.getNombre(), 0, 1);
        table.setValueAt(cliente.getApellido(), 0, 2);
        table.setValueAt(cliente.getActividadesInscripto(), 0, 3);
        table.setValueAt(cliente.geteMail(), 0, 4);
        table.setValueAt(cliente.getDNI(), 0, 5);
        table.setValueAt(cliente.getPeso(), 0, 6);
        table.setValueAt(cliente.getAltura(), 0, 7);
        table.setValueAt(cliente.getSexo(), 0, 8);
        table.setValueAt(cliente.isCuotaPagada(), 0, 9);
    }

//    private void actualizarTablaClienteAModificar( Cliente clienteActual){
//
//        TableModel table = TablaClienteAModificar.getModel();
//        TablaClienteAModificar.setModel(table);
//
//        TablaClienteAModificar.setValueAt(clienteActual.getIdCliente(), 0, 0);
//        table.setValueAt(clienteActual.getNombre(), 0, 1);
//        table.setValueAt(clienteActual.getApellido(), 0, 2);
//        table.setValueAt(clienteActual.getActividadesInscripto(), 0, 3);
//        table.setValueAt(clienteActual.geteMail(), 0, 4);
//        table.setValueAt(clienteActual.getDNI(), 0, 5);
//        table.setValueAt(clienteActual.getPeso(), 0, 6);
//        table.setValueAt(clienteActual.getAltura(), 0, 7);
//        table.setValueAt(clienteActual.getSexo(), 0, 8);
//        table.setValueAt(clienteActual.isCuotaPagada(), 0, 9);
//
//
//    }

}