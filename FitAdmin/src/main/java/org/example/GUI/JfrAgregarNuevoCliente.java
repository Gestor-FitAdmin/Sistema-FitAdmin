package org.example.GUI;

import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Persona;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JfrAgregarNuevoCliente extends javax.swing.JFrame {

    private javax.swing.JButton BotonIrAtras;
    private javax.swing.JComboBox<String> SelectorDeActividades;
    private javax.swing.JTextField TextAreaApellido;
    private javax.swing.JTextField TextAreaDNI;
    private javax.swing.JTextField TextAreaNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField TextAreaFechaDeNacimiento;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField TextAreaAltura;
    private javax.swing.JTextField TextAreaPeso;
    private javax.swing.JTextField TextAreaEmail;
    private javax.swing.JComboBox<String> selectorDeSexo;

    public JfrAgregarNuevoCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());
    }


    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TextAreaNombre = new javax.swing.JTextField();
        TextAreaApellido = new javax.swing.JTextField();
        selectorDeSexo = new javax.swing.JComboBox<>();
        TextAreaDNI = new javax.swing.JTextField();
        TextAreaAltura = new javax.swing.JTextField();
        TextAreaPeso = new javax.swing.JTextField();
        TextAreaEmail = new javax.swing.JTextField();
        TextAreaFechaDeNacimiento = new javax.swing.JTextField();
        SelectorDeActividades = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        BotonIrAtras = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("DNI");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Sexo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Peso");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Altura");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Fecha de nacimiento");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("E-Mail");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Actividad");

        TextAreaNombre.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaNombre.setForeground(new java.awt.Color(242, 242, 242));
        TextAreaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaNombreActionPerformed(evt);
            }
        });

        TextAreaApellido.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaApellido.setForeground(new java.awt.Color(242, 242, 242));
        TextAreaApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaApellidoActionPerformed(evt);
            }
        });

        selectorDeSexo.setBackground(new java.awt.Color(130, 130, 130));
        selectorDeSexo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        selectorDeSexo.setForeground(new java.awt.Color(242, 242, 242));
        selectorDeSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Hombre", "Mujer"}));
        selectorDeSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorDeSexoActionPerformed(evt);
            }
        });

        TextAreaDNI.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaDNI.setForeground(new java.awt.Color(242, 242, 242));
        TextAreaDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaDNIActionPerformed(evt);
            }
        });


        TextAreaAltura.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaAltura.setForeground(new java.awt.Color(242, 242, 242));

        TextAreaPeso.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaPeso.setForeground(new java.awt.Color(242, 242, 242));

        TextAreaEmail.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaEmail.setForeground(new java.awt.Color(242, 242, 242));

        TextAreaFechaDeNacimiento.setBackground(new java.awt.Color(130, 130, 130));
        TextAreaFechaDeNacimiento.setForeground(new java.awt.Color(242, 242, 242));
        TextAreaFechaDeNacimiento.setText("dd/MM/yyyy");

        SelectorDeActividades.setBackground(new java.awt.Color(130, 130, 130));
        SelectorDeActividades.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SelectorDeActividades.setForeground(new java.awt.Color(242, 242, 242));
        SelectorDeActividades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Musculacion"}));
        SelectorDeActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectorDeActividadesActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(130, 130, 130));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("Inscribir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(85, 85, 85))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(101, 101, 101))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(94, 94, 94))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(jLabel10))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SelectorDeActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(TextAreaPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextAreaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextAreaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(TextAreaFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(36, 36, 36)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(selectorDeSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(81, 81, 81)
                                                                                .addComponent(jLabel9))))
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonIrAtras))))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectorDeSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaFechaDeNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SelectorDeActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonIrAtras)
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void TextAreaApellidoActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:

    }

    private void SelectorDeActividadesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;  // Inicializa como true
        Gimnasio gym = GUIEnvoltorio.getGimnasio();
        String sexo = (String) selectorDeSexo.getSelectedItem();
        String actividadInscripto = (String) SelectorDeActividades.getSelectedItem();


        Double altura = Double.parseDouble(TextAreaAltura.getText());
        Double peso = Double.parseDouble(TextAreaPeso.getText());
        int idSocio = proximoIdSocio();

        // Validar nombre
        if (verificarSiContieneNumero(TextAreaNombre.getText())) {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("No puede ingresar digitos en el nombre");
            TextAreaNombre.setText(null);
            flag = false;
        }

        // Validar apellido
        if (verificarSiContieneNumero(TextAreaApellido.getText())) {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("No puede ingresar digitos en el apellido");
            TextAreaApellido.setText(null);
            flag = false;
        }

        // Validar email
        if (verificarArroba(TextAreaEmail.getText())) {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("Olvido poner su @ en el e-Mail");
            TextAreaEmail.setText(null);
            flag = false;
        }


        if (verificarDNIExistente()||verificarTamDNI())//si ya existe el DNI en el sistema o si no cumple con los requisitos
        {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("DNI ya existente o es invalido");
            TextAreaDNI.setText(null);
            flag = false;
        }

        if(flag)//si pasa las validaciones
        {

            // Solo si flag sigue siendo true
            Cliente cliente = new Cliente(
                    TextAreaNombre.getText(),
                    TextAreaApellido.getText(),
                    TextAreaDNI.getText(),
                    sexo,
                    peso,
                    altura,
                    TextAreaFechaDeNacimiento.getText(),
                    TextAreaEmail.getText(),
                    true
            );

            cliente.agregarActividadACliente(actividadInscripto);
            gym.agregar(cliente);
            System.out.println(gym);
            System.out.println(cliente);
        }



    }

    public int proximoIdSocio(){
        return 1;
    }

    public void TextAreaNombreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void TextAreaDNIActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void selectorDeSexoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // peso
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // Altura
    }

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // Email
    }

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {
        // Fecha de nacimeinto
    }

    private void BotonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);
    }
    private boolean verificarSiContieneNumero(String aComparar)
    {
        boolean rta = false;
        for (int i = 0; i < aComparar.length(); i++)
        {
            if (Character.isDigit(aComparar.charAt(i)))
            {
                rta = true;
            }
        }
        return rta;
    }
    private boolean verificarArroba(String aComparar)
    {
        boolean rta = false;

           if(!aComparar.contains("@"))
           {
            rta = true;
           }
        return rta;
    }
    private boolean verificarDNIExistente()
    {
        Gimnasio gym = GUIEnvoltorio.getGimnasio();
        boolean rta = false;
        HashMap<Integer, Cliente> clientes = gym.getClientes();
        for (Map.Entry<Integer, Cliente> entry : clientes.entrySet()) {
            Persona siExiste =(Cliente) entry.getValue();
            if(siExiste.getDNI().equals(TextAreaDNI.getText()))
            {
                rta = true;//es true si ya existe el DNI
            }
        }
        return rta;
    }
    private boolean verificarTamDNI()
    {
        boolean rta = false;
        String aVerificar = TextAreaDNI.getText();
        if(aVerificar.length()<7 ||aVerificar.length()>8)
        {
            rta = true;
        }


        return rta;
    }

}


