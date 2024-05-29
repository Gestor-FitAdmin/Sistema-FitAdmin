package org.example.GUI.PopUps;

public class JfrAvisoPopUp extends javax.swing.JDialog {
    //atributos

    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel mensajeLabel;
    private javax.swing.JPanel jPanel1;



    public JfrAvisoPopUp(java.awt.Frame parent, boolean modal, String mensaje) {
        super(parent, modal);
        initComponents();
        mensajeLabel.setText(mensaje);

        pack(); // Ajustar el tamaño del diálogo para que se ajuste a su contenido
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        mensajeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 80, 32));

        botonAceptar.setText("Aceptar");
        botonAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        mensajeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mensajeLabel.setForeground(new java.awt.Color(250, 250, 250));
        mensajeLabel.setText("Aviso al usuario");
        mensajeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Centrar el texto horizontalmente
        mensajeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        // Modificar el layout para que se centre y ajuste automáticamente al contenido
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(mensajeLabel)
                                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)) // Ajustar el tamaño del botón
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(mensajeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack(); // Ajustar el tamaño del diálogo para que se ajuste a su contenido
    }

    // Acción del botón
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }


}
