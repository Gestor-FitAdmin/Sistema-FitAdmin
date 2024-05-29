package org.example.GUI.PopUps;

import com.dropbox.core.DbxException;
import org.example.API.DropBoxAPI;

import java.awt.*;
import java.net.URI;

public class JfrAutenticacionPopUp extends javax.swing.JFrame{
    // atributos
    private javax.swing.JLabel TituloDropbox;
    private javax.swing.JButton botonAutenticar;
    private javax.swing.JTextField codigoAutenticacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pasoDos;
    private javax.swing.JLabel pasoTres;
    private javax.swing.JLabel pasoUno;
    private javax.swing.JLabel urlAAsignar;
    private DropBoxAPI dropBoxAPI;

    public JfrAutenticacionPopUp(DropBoxAPI dropBoxAPI) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        this.dropBoxAPI=dropBoxAPI;
        urlAAsignar.setText(dropBoxAPI.autenticarTokenNuevoURL());


    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TituloDropbox = new javax.swing.JLabel();
        pasoUno = new javax.swing.JLabel();
        pasoDos = new javax.swing.JLabel();
        urlAAsignar = new javax.swing.JLabel();
        pasoTres = new javax.swing.JLabel();
        codigoAutenticacion = new javax.swing.JTextField();
        botonAutenticar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 300));

        jPanel1.setBackground(new java.awt.Color(32, 32, 32));

        TituloDropbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloDropbox.setForeground(new java.awt.Color(250, 250, 250));
        TituloDropbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloDropbox.setText("Autenticacion con DropBox");

        pasoUno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasoUno.setForeground(new java.awt.Color(250, 250, 250));
        pasoUno.setText("1) Inicie sesion en DropBox si no tiene cuenta cree una");

        pasoDos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasoDos.setForeground(new java.awt.Color(250, 250, 250));
        pasoDos.setText("2) Ingrese a esta URL:");

        urlAAsignar.setForeground(new java.awt.Color(0, 200, 250));
        urlAAsignar.setText("codigo");
        urlAAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urlAAsignarMouseClicked(evt);
            }
        });
        urlAAsignar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pasoTres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasoTres.setForeground(new java.awt.Color(250, 250, 250));
        pasoTres.setText("3) Ingrese el codigo obtenido aqui: ");

        codigoAutenticacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoAutenticacionActionPerformed(evt);
            }
        });

        botonAutenticar.setText("OK");
        botonAutenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAutenticarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pasoUno)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(pasoTres)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(codigoAutenticacion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 43, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(pasoDos)
                                                .addGap(269, 269, 269))
                                        .addComponent(urlAAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(botonAutenticar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TituloDropbox, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TituloDropbox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pasoUno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(pasoDos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(urlAAsignar)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pasoTres)
                                        .addComponent(codigoAutenticacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(botonAutenticar)
                                .addGap(25, 25, 25))
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

    private void botonAutenticarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        //verificar si esta vacio el texto, si esta vacio tiro pop de error, y si no esta vacio, verifico que codigo este bien ingresado

        String codigoAut= codigoAutenticacion.getText();
        codigoAut= codigoAut.replace(" ",""); //le saco todos los espacios

        if (!codigoAut.isEmpty())
        {
            try {

                String tokenNuevo= dropBoxAPI.autenticarCliente(codigoAut); //si se rompe es porque se ingreso mal el codigo de acceso
                dropBoxAPI.guardarTokenEnArchivo(tokenNuevo);
                setVisible(false);
            }
            catch (DbxException e)
            {
                JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("Ingrese un codigo valido");
                e.getMessage();
            }

        }
        else
        {
            JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("Ingrese un codigo valido");
        }




    }

    private void codigoAutenticacionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void urlAAsignarMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            Desktop.getDesktop().browse(new URI(urlAAsignar.getText()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
