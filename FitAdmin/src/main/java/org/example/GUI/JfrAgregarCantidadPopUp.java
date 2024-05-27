package org.example.GUI;

import org.example.Modelo.Ejercicio;

import javax.swing.*;
import java.awt.*;

public class JfrAgregarCantidadPopUp extends JDialog {

    //atributos
    private javax.swing.JButton botonGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nroRepeticiones;
    private javax.swing.JLabel nroSeries;
    private javax.swing.JSpinner spinnerRepeticiones;
    private javax.swing.JSpinner spinnerSeries;

    private Ejercicio ejercicioAux;

    public JfrAgregarCantidadPopUp(Ejercicio ejercicioAux) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        this.ejercicioAux=ejercicioAux;
    }

    public Ejercicio getEjercicioAux() {
        return ejercicioAux;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton();
        spinnerSeries = new javax.swing.JSpinner();
        nroSeries = new javax.swing.JLabel();
        nroRepeticiones = new javax.swing.JLabel();
        spinnerRepeticiones = new javax.swing.JSpinner();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 32, 32));

        botonGuardar.setText("OK");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        spinnerSeries.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerSeries.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
        ajustarTamanoSpinner(spinnerSeries,40,40);


        nroSeries.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nroSeries.setForeground(new java.awt.Color(250, 250, 250));
        nroSeries.setText("N° Series");

        spinnerRepeticiones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerRepeticiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajustarTamanoSpinner(spinnerRepeticiones,40,40);

        nroRepeticiones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nroRepeticiones.setForeground(new java.awt.Color(250, 250, 250));
        nroRepeticiones.setText("N° Repeticiones");








        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nroSeries)
                                        .addComponent(spinnerSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nroRepeticiones)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spinnerRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)))
                                .addGap(14, 14, 14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(botonGuardar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(nroSeries)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spinnerSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(31, 31, 31)
                                                        .addComponent(spinnerRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(nroRepeticiones)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(botonGuardar)
                                .addGap(17, 17, 17))
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
    }

    private void ajustarTamanoSpinner(JSpinner componenteSpinner, int ancho, int alto){
        JComponent textoSpinner = ((JSpinner.DefaultEditor) componenteSpinner.getEditor());
        Dimension prefSize = new Dimension(ancho, alto);
        textoSpinner.setPreferredSize(prefSize);
    }

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        ejercicioAux.setSeries((Integer) spinnerSeries.getValue());
        ejercicioAux.setRepeticiones((Integer) spinnerRepeticiones.getValue());
        this.setVisible(false);
    }


}
