package org.example.GUI.PopUps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfrErrorPopUp extends javax.swing.JDialog{
    //atributos
    private String mensajeError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton botonAceptar;


    //constructor

    public JfrErrorPopUp(java.awt.Frame parent, boolean modal,String mensajeError)
    {
        super(parent,"Error",modal);
        initComponents(mensajeError);
        setLocationRelativeTo(null);
        this.mensajeError=mensajeError;
        this.setVisible(true);
        setResizable(false);
    }

    //setter




        private void initComponents(String mensajeError) {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            botonAceptar = new javax.swing.JButton();

            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Ocurrió un error");

            jPanel1.setBackground(new java.awt.Color(200, 200, 200));
            jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 50, 20, 50));

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText(mensajeError);

            jLabel2.setForeground(new java.awt.Color(240, 0, 0));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("ERROR");

            botonAceptar.setText("Aceptar");
            botonAceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    botonAceptarActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(botonAceptar)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

            pack();
        }// </editor-fold>

        private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose(); // Cierra el diálogo cuando se presiona el botón "Aceptar"
        }






    //metodos


}
