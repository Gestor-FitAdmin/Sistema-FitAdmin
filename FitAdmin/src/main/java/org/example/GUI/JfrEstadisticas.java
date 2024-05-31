package org.example.GUI;

import org.example.Enum.ESexo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.Objects;

public class JfrEstadisticas  extends javax.swing.JFrame{


    private javax.swing.JTextArea AreaDeTextoEstadisticas;
    private javax.swing.JButton BotonAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;



    public JfrEstadisticas() {
        initComponents();
        actualizarTextoEstadisticas();
        setLocationRelativeTo(null);
        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());
    }



    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaDeTextoEstadisticas = new javax.swing.JTextArea();
        BotonAtras = new javax.swing.JButton();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        AreaDeTextoEstadisticas.setEditable(false);
        AreaDeTextoEstadisticas.setBackground(new java.awt.Color(130, 130, 130));
        AreaDeTextoEstadisticas.setColumns(0);
        AreaDeTextoEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        AreaDeTextoEstadisticas.setForeground(new java.awt.Color(242, 242, 242));
        AreaDeTextoEstadisticas.setRows(0);
        AreaDeTextoEstadisticas.setTabSize(0);
        AreaDeTextoEstadisticas.setBorder(null);
        jScrollPane2.setViewportView(AreaDeTextoEstadisticas);

        AreaDeTextoEstadisticas.setPreferredSize(new Dimension(200,350));//ajustamos el area como predeterminada

        BotonAtras.setBackground(new java.awt.Color(63, 63, 63));
        BotonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonAtras.setBorder(null);
        BotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(BotonAtras)))
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonAtras)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );



        pack();
    }


    private void BotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrMenuPrincipal menu = new JfrMenuPrincipal();
        menu.setVisible(true);
    }

    public void actualizarTextoEstadisticas(){
        String textoConEstadisticas="";

        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes: "+ GUIEnvoltorio.getGimnasio().contarTotalClientes()+"\n");
        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes activos: "+ GUIEnvoltorio.getGimnasio().contarClientesActivos()+"\n");
        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes inactivos: "+ GUIEnvoltorio.getGimnasio().contarClientesInactivos()+"\n");
        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes en musculacion: "+ GUIEnvoltorio.getGimnasio().contarClientesXActividad("musculacion")+"\n");
        //puede haber mas actividades...


        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes sexo masculino: "+ GUIEnvoltorio.getGimnasio().contarClientesXGenero(ESexo.MASCULINO)+"\n");
        textoConEstadisticas= textoConEstadisticas.concat("Total de clientes sexo femenino: "+ GUIEnvoltorio.getGimnasio().contarClientesXGenero(ESexo.FEMENINO)+"\n");
        textoConEstadisticas= textoConEstadisticas.concat("Total recaudado: $"+ GUIEnvoltorio.getGimnasio().recaudacionTotal()+"\n");


        AreaDeTextoEstadisticas.setText(textoConEstadisticas);
    }
}
