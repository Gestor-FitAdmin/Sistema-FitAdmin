package org.example.GUI;

import org.example.Enum.EDiasSemana;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Rutina;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class JfrGenerarRutina extends javax.swing.JFrame {

    private javax.swing.JButton BotonAgregarEjercicioARutina;
    private javax.swing.JButton BotonAgregarRutinaCreada;
    private javax.swing.JButton BotonIrAtras;
    private javax.swing.JComboBox<String> SelectorDeObjetivos;
    private javax.swing.JComboBox<String> SelectorDeDias;
    private javax.swing.JTable TablaDeEjercicios;
    private javax.swing.JTable TablaRutinaActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    //atributos para agregar en el cliente
    private Rutina rutina;//si esta vacia que saque un popUp que no se puede agregar rutina vacia
    private Cliente clienteActual;
    private ArrayList<Ejercicio> ejerciciosJson;
    public JfrGenerarRutina(Cliente clienteActual) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        rutina = new Rutina();
        this.clienteActual=clienteActual;
        try {
            ejerciciosJson= rutina.leerJSONEjercicio();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        llenarTablaConEjercicios();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SelectorDeObjetivos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SelectorDeDias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeEjercicios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaRutinaActual = new javax.swing.JTable();
        BotonAgregarRutinaCreada = new javax.swing.JButton();
        BotonAgregarEjercicioARutina = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BotonIrAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Objetivo");

        SelectorDeObjetivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"PERDER_PESO", "GANAR_MUSCULO", "GANAR_FUERZA"}));
        SelectorDeObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                SelectorDeObjetivosActionPerformed(evt);
                String eObjetivo = (String) SelectorDeObjetivos.getSelectedItem();
                System.out.println(eObjetivo);
                rutina.setObjetivo(eObjetivo);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Día");

        SelectorDeDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"}));
        //falta el cliente para poder agregarle el dia
        TablaDeEjercicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Nombre", "Complejidad", "Material"
                }


        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }


        });

        SelectorDeDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                SelectorDeDiasActionPerformed(evt);

            }
        });

        TablaDeEjercicios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {


            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TablaDeEjercicios.getSelectedRow();
                    if (selectedRow != -1) {
                        String nombre = TablaDeEjercicios.getValueAt(selectedRow, 0).toString();
                        String dificultad = TablaDeEjercicios.getValueAt(selectedRow, 1).toString();
                        String materiales = TablaDeEjercicios.getValueAt(selectedRow, 2).toString();

                    }

                }


            }
        });
        jScrollPane1.setViewportView(TablaDeEjercicios);

        TablaRutinaActual.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null,null,null},
                },
                new String[]{
                        "Nombre", " Complejidad", "Material", "N°sr", "N°rep"
                }
        ));
        jScrollPane2.setViewportView(TablaRutinaActual);

        BotonAgregarRutinaCreada.setBackground(new java.awt.Color(130, 130, 130));
        BotonAgregarRutinaCreada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonAgregarRutinaCreada.setForeground(new java.awt.Color(242, 242, 242));
        BotonAgregarRutinaCreada.setText("Agregar Rutina");
        BotonAgregarRutinaCreada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarRutinaCreadaActionPerformed(evt);
            }
        });

        BotonAgregarEjercicioARutina.setBackground(new java.awt.Color(130, 130, 130));
        BotonAgregarEjercicioARutina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonAgregarEjercicioARutina.setForeground(new java.awt.Color(242, 242, 242));
        BotonAgregarEjercicioARutina.setText("Agregar Ejercicio a Rutina");
        BotonAgregarEjercicioARutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarEjercicioARutinaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Lista de ejercicios :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Rutina actual: ");

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
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(45, 45, 45))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(45, 45, 45)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(SelectorDeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(SelectorDeObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                                .addComponent(jLabel4))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(BotonIrAtras)))
                                                                .addGap(15, 15, 15))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(BotonAgregarEjercicioARutina))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(BotonAgregarRutinaCreada)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(SelectorDeObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(SelectorDeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonAgregarEjercicioARutina)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BotonAgregarRutinaCreada)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BotonIrAtras)
                                                .addContainerGap())))
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
    }// </editor-fold>


    private void BotonAgregarRutinaCreadaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:






    }

    private void BotonAgregarEjercicioARutinaActionPerformed(java.awt.event.ActionEvent evt) {
        //Funcionalidad para pasar los ejerciiso de seleccioandos a la lista de la nueva rutina
        //DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nombre", "Complejidad", "Material"}, TablaRutinaActual.getRowCount());
        // TablaDeEjercicios.setModel(tableModel);



        int filaSeleccionada = TablaDeEjercicios.getSelectedRow();




        Ejercicio ejercicio;

        String nombreEjercicioElegido="";

        if (filaSeleccionada != -1 && TablaDeEjercicios.getValueAt(filaSeleccionada,0) != null) {

            nombreEjercicioElegido= (String) TablaDeEjercicios.getValueAt(filaSeleccionada,0); // obtengo el nombre
            ejercicio = rutina.buscarUnEjercicioXNombre(nombreEjercicioElegido); //busco el ejercicio


            //TODO PROBLEMA A SOLUCIONAR NO SE ASIGNAN LAS SERIES Y REPS DEBIDO A QUE CUANDO CREO EL POPUP EL PROGRAMA SIGUE CORRIENDO, BUSCAR FORMA DE PAUSAR EL PROGRAMA

            JfrAgregarCantidadPopUp jfrAgregarCantidadPopUp=new JfrAgregarCantidadPopUp(ejercicio);//asigno series y ejercicios


            DefaultTableModel modeloDatos = (DefaultTableModel) TablaRutinaActual.getModel(); //este es un formateo para poder agregar filas



            if(modeloDatos.getValueAt(0,0 )!= null) {
                    // sino agrego una fila nueva
                    modeloDatos.addRow(new String[]{ejercicio.getNombreEjercicio(), ejercicio.getComplejidad(), ejercicio.getMaterialDeTrabajo(),String.valueOf(ejercicio.getSeries()),String.valueOf(ejercicio.getRepeticiones())});

                }
                else
                {
                    //si la tabla esta vacia, directamente pongo el ejercicio en el primer lugar
                    asignarUnEjercicioATabla(modeloDatos,ejercicio,0);
                }

        }
        else{
            JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp("Elija un ejercicio para asignarlo a la rutina");
        }

    }

    private void SelectorDeObjetivosActionPerformed(java.awt.event.ActionEvent evt) {
        String eObjetivo = (String) SelectorDeObjetivos.getSelectedItem();

        rutina.setObjetivo(eObjetivo);
    }

    private void SelectorDeDiasActionPerformed(java.awt.event.ActionEvent evt) {

        String sDiasSemana=(String) SelectorDeDias.getSelectedItem();

        EDiasSemana enumDiaSemana= EDiasSemana.valueOf(sDiasSemana);

        cargarTablaRutinaActualDependeElDia(enumDiaSemana);

    }

    private void cargarTablaRutinaActualDependeElDia(Enum diaSeleccionado)
    {
        rutina= clienteActual.getRutinaSemanal().get(diaSeleccionado.toString());
        int i=0;
        System.out.println(rutina);
        for (Ejercicio ejercicio: rutina.getRutina())
        {
            asignarUnEjercicioATabla(TablaRutinaActual.getModel(),ejercicio,i);
            i++;
        }

    }



    private void BotonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);
    }


    private void llenarTablaConEjercicios() {

//        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nombre", "Complejidad", "Material"}, ejerciciosJson.size());
//        TablaDeEjercicios.setModel(tableModel);
        DefaultTableModel tableModel = (DefaultTableModel) TablaDeEjercicios.getModel();

        TableModel modeloDeDatos = TablaDeEjercicios.getModel();

        int i = 0;
        for (Ejercicio ejercicio : ejerciciosJson) {


            Ejercicio ejercicioResumido = new Ejercicio(ejercicio.getNombreEjercicio(), ejercicio.getComplejidad(), ejercicio.getMaterialDeTrabajo());
            tableModel.addRow(new String[]{"Nombre", " Complejidad", "Material", "N°sr", "N°rep"});
            asignarUnEjercicioATabla(modeloDeDatos,ejercicioResumido,i);

            i++;
        }
    }

    private void asignarUnEjercicioATabla(TableModel modeloDeDatos,Ejercicio ejercicioActual,int fila)
    {
        modeloDeDatos.setValueAt(ejercicioActual.getNombreEjercicio(), fila, 0);
        modeloDeDatos.setValueAt(ejercicioActual.getComplejidad(), fila, 1);
        modeloDeDatos.setValueAt(ejercicioActual.getMaterialDeTrabajo(), fila, 2);
    }

}


