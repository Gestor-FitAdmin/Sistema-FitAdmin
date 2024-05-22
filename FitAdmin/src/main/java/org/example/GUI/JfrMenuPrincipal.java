package org.example.GUI;


import javax.swing.table.DefaultTableModel;

import javax.swing.JFrame;


public class JfrMenuPrincipal extends javax.swing.JFrame {

    // Variables declaration
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonEstadisticas;
    private javax.swing.JButton BotonIngresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration


        public JfrMenuPrincipal() {
            initComponents();
            setLocationRelativeTo(null);

        }
        /*
        public void agregarClientesATabla(){
            dtm.addRow(new Object [] {

                //Aca hay que recorrer la estructura donde esten los clientes
                 // Se deberia escribir algo como


            }
        }
        */




        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jMenu3 = new javax.swing.JMenu();
            jLabel2 = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tblDatos = new javax.swing.JTable();
            BotonClientes = new javax.swing.JButton();
            BotonEstadisticas = new javax.swing.JButton();
            BotonIngresos = new javax.swing.JButton();

            jMenu3.setText("jMenu3");

            jLabel2.setText("jLabel2");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(63, 63, 63));
            jPanel1.setForeground(new java.awt.Color(63, 63, 63));
            jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

            tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                    },
                    new String [] {
                            "Id", "Nombre", "Apellido", "Actividad"
                    }
            ) {
                boolean[] canEdit = new boolean [] {
                        false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane1.setViewportView(tblDatos);
            if (tblDatos.getColumnModel().getColumnCount() > 0) {
                tblDatos.getColumnModel().getColumn(0).setResizable(false);
                tblDatos.getColumnModel().getColumn(1).setResizable(false);
                tblDatos.getColumnModel().getColumn(2).setResizable(false);
                tblDatos.getColumnModel().getColumn(3).setResizable(false);
            }

            BotonClientes.setBackground(new java.awt.Color(130, 130, 130));
            BotonClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            BotonClientes.setForeground(new java.awt.Color(242, 242, 242));
            BotonClientes.setText("Clientes");
            BotonClientes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BotonClientesActionPerformed(evt);
                }
            });

            BotonEstadisticas.setBackground(new java.awt.Color(130, 130, 130));
            BotonEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            BotonEstadisticas.setForeground(new java.awt.Color(242, 242, 242));
            BotonEstadisticas.setText("Estadísticas");
            BotonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BotonEstadisticasActionPerformed(evt);
                }
            });

            BotonIngresos.setBackground(new java.awt.Color(130, 130, 130));
            BotonIngresos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            BotonIngresos.setForeground(new java.awt.Color(242, 242, 242));
            BotonIngresos.setText("Ingresos");
            BotonIngresos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BotonIngresosActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(BotonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotonIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(53, 53, 53)
                                                    .addComponent(jLabel1)))
                                    .addContainerGap(22, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BotonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                            .addComponent(BotonEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BotonIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addGap(54, 54, 54))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 23, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>

        private void BotonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void BotonIngresosActionPerformed(java.awt.event.ActionEvent evt) {
            /*
            this.setVisible(false);
            JfrAccesos acce = new JfrAccesos();
            acce.setVisible(true);

             */
        }

        private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {
            /*
            this.setVisible(false);
            JfrClientes cliente = new JfrClientes();
            cliente.setVisible(true);

             */
        }
    }


