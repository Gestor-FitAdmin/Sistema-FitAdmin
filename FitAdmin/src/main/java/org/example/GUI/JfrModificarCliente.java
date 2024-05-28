package org.example.GUI;

public class JfrModificarCliente extends javax.swing.JFrame {


    private javax.swing.JButton BotonGuardarCambios;
    private javax.swing.JButton BotonIrAtras;
    private javax.swing.JComboBox<String> ComboBoxModificar;
    private javax.swing.JTable TablaClienteAModificar;
    private javax.swing.JTextField TextFieldModificar;
    private javax.swing.JToggleButton ToggleButtonPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;


    public JfrModificarCliente() {
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClienteAModificar = new javax.swing.JTable();
        ComboBoxModificar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TextFieldModificar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ToggleButtonPagar = new javax.swing.JToggleButton();
        BotonGuardarCambios = new javax.swing.JButton();
        BotonIrAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        TablaClienteAModificar.setModel(new javax.swing.table.DefaultTableModel(
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

        ComboBoxModificar.setBackground(new java.awt.Color(130, 130, 130));
        ComboBoxModificar.setForeground(new java.awt.Color(242, 242, 242));
        ComboBoxModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nombre", "Apellido", "E-Mail", "DNI", "Peso", "Altura"}));
        ComboBoxModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxModificarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Modificar : ");

        TextFieldModificar.setBackground(new java.awt.Color(130, 130, 130));
        TextFieldModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TextFieldModificar.setForeground(new java.awt.Color(242, 242, 242));
        TextFieldModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldModificarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Nuevo Dato : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Cuota");

        ToggleButtonPagar.setBackground(new java.awt.Color(130, 130, 130));
        ToggleButtonPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ToggleButtonPagar.setForeground(new java.awt.Color(242, 242, 242));
        ToggleButtonPagar.setText("Pagar");
        ToggleButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleButtonPagarActionPerformed(evt);
            }
        });

        BotonGuardarCambios.setBackground(new java.awt.Color(130, 130, 130));
        BotonGuardarCambios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonGuardarCambios.setForeground(new java.awt.Color(242, 242, 242));
        BotonGuardarCambios.setText("Guardar Cambio");
        BotonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarCambiosActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new java.awt.Color(63, 63, 63));
        BotonIrAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setToolTipText("");
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(238, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(220, 220, 220))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(TextFieldModificar)
                                                                        .addComponent(ComboBoxModificar, 0, 148, Short.MAX_VALUE)
                                                                        .addComponent(ToggleButtonPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(230, 230, 230))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BotonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(251, 251, 251))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BotonIrAtras)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ComboBoxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextFieldModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(ToggleButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(BotonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(BotonIrAtras)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void ToggleButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {

        if(ToggleButtonPagar.isSelected()){
            ToggleButtonPagar.setText("Pagar");
        }else {
            ToggleButtonPagar.setText("Pagado");
        }
    }

    private void ComboBoxModificarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TextFieldModificarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BotonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BotonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);

    }

}