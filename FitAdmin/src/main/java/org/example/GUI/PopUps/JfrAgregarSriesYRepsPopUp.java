package org.example.GUI.PopUps;


import org.example.Modelo.Ejercicio;

import javax.swing.*;
import java.awt.*;

public class JfrAgregarSriesYRepsPopUp extends javax.swing.JDialog {
    //atributos
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel labelRepeticiones;
    private javax.swing.JLabel labelSeries;
    private javax.swing.JSpinner spinnerDeSeries;
    private javax.swing.JSpinner spinnerDeRepeticiones;
    private Ejercicio ejercicioElegido;




    public JfrAgregarSriesYRepsPopUp(java.awt.Frame parent, boolean modal, Ejercicio ejercicioElegido) {
        super(parent, modal);
        initComponents();
        this.ejercicioElegido= ejercicioElegido;
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }



    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        botonFinalizar = new javax.swing.JButton();
        labelSeries = new javax.swing.JLabel();
        labelRepeticiones = new javax.swing.JLabel();
        spinnerDeSeries = new javax.swing.JSpinner();
        spinnerDeRepeticiones = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(40, 40, 40));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);

        jPanel.setBackground(new java.awt.Color(40, 40, 40));
        jPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel.setForeground(new java.awt.Color(70, 70, 70));

        botonFinalizar.setText("Aceptar");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        labelSeries.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelSeries.setForeground(new java.awt.Color(250, 250, 250));
        labelSeries.setText("Series");

        labelRepeticiones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelRepeticiones.setForeground(new java.awt.Color(250, 250, 250));
        labelRepeticiones.setText("Repeticiones");

        spinnerDeSeries.setAutoscrolls(true);
        spinnerDeSeries.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spinnerDeSeries.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinnerDeSeries.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        ajustarTamanoSpinner(spinnerDeSeries,60,40);

        spinnerDeRepeticiones.setAutoscrolls(true);
        spinnerDeRepeticiones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spinnerDeRepeticiones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinnerDeRepeticiones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        ajustarTamanoSpinner(spinnerDeRepeticiones,60,40);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(spinnerDeSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(spinnerDeRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addComponent(labelSeries)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                                .addComponent(labelRepeticiones))))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(botonFinalizar)))
                                .addGap(25, 25, 25))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelRepeticiones)
                                        .addComponent(labelSeries))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(spinnerDeSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spinnerDeRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(botonFinalizar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
        ejercicioElegido.setSeries((Integer) spinnerDeSeries.getValue());
        ejercicioElegido.setRepeticiones((Integer) spinnerDeRepeticiones.getValue());
        this.setVisible(false);
    }

    private void ajustarTamanoSpinner(JSpinner componenteSpinner, int ancho, int alto){
        JComponent textoSpinner = ((JSpinner.DefaultEditor) componenteSpinner.getEditor());
        Dimension prefSize = new Dimension(ancho, alto);
        textoSpinner.setPreferredSize(prefSize);
    }

}