package org.example.GUI;

import org.example.Enum.EDiasSemana;
import org.example.GUI.PopUps.JfrAgregarSriesYRepsPopUp;
import org.example.GUI.PopUps.JfrAvisoPopUp;
import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.Modelo.Cliente;
import org.example.Modelo.Ejercicio;
import org.example.Modelo.Rutina;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrGenerarRutina extends javax.swing.JFrame {

    private javax.swing.JButton BotonAgregarEjercicioARutina;
    private javax.swing.JButton BotonAgregarRutinaCreada;
    private javax.swing.JButton BotonSacarEjercicioRutina;
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
    private Rutina rutinaSeleccionada;
    private Cliente clienteActual;
    private ArrayList<Ejercicio> ejerciciosJson;
    private ArrayList<Ejercicio> ejerciciosElegidos; // se hace un arraylist de los ejercicios elegidos como un "stage" por si el usuario vuelve hacia atras

    public JfrGenerarRutina(Cliente clienteActual) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());


        ejerciciosElegidos = new ArrayList<>();

        rutinaSeleccionada = clienteActual.getUnaRutinaEspecifica(EDiasSemana.LUNES);

        cargarTablaRutinaActualDependeElDia(rutinaSeleccionada.getDiaAsignado());

        this.clienteActual = clienteActual;

        try {
            ejerciciosJson = rutinaSeleccionada.leerJSONEjercicio();
        } catch (IOException e) {
            e.printStackTrace();
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
        BotonSacarEjercicioRutina = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BotonIrAtras = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // No cerrar directamente

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                // Crear el panel de opciones con los botones personalizados
                Object[] options = {"Si", "No"};
                int option = JOptionPane.showOptionDialog(
                        JfrGenerarRutina.this,
                        "¿Desea salir?",
                        "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (option == JOptionPane.YES_OPTION) {
                    // Llamar al método de guardar cambios antes de cerrar
                    gimnasio.guardarClientesEnArchivo("clientes.bin");
                    System.exit(0);
                }
            }
        });

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

                rutinaSeleccionada.setObjetivo(eObjetivo);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Día");

        SelectorDeDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"}));
        //falta el cliente para poder agregarle el dia
        TablaDeEjercicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
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


        jScrollPane1.setViewportView(TablaDeEjercicios);

        TablaRutinaActual.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
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

        BotonSacarEjercicioRutina.setBackground(new java.awt.Color(130, 130, 130));
        BotonSacarEjercicioRutina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonSacarEjercicioRutina.setForeground(new java.awt.Color(242, 242, 242));
        BotonSacarEjercicioRutina.setText("Remover ejercicio");
        BotonSacarEjercicioRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSacarEjercicioRutinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SelectorDeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SelectorDeObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                .addGap(94, 94, 94))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonIrAtras)
                                                .addGap(37, 37, 37)
                                                .addComponent(BotonAgregarRutinaCreada)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BotonSacarEjercicioRutina)
                                                .addGap(83, 83, 83))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(28, 28, 28)
                                                .addComponent(BotonAgregarEjercicioARutina)))
                                .addContainerGap(28, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BotonAgregarEjercicioARutina))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(BotonIrAtras))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BotonAgregarRutinaCreada)
                                                        .addComponent(BotonSacarEjercicioRutina))))
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//


    private void BotonAgregarRutinaCreadaActionPerformed(java.awt.event.ActionEvent evt) {

        //si no tengo ejercicios elegidos no puedo crear una rutina vacia, por lo tanto popUp que no se puede agregar rutina vacia

        if (!ejerciciosElegidos.isEmpty()) {
            if(ejerciciosElegidos.size() >= 3) {
                rutinaSeleccionada.setObjetivo((String) SelectorDeObjetivos.getSelectedItem());

                for (int i = 0; i < ejerciciosElegidos.size(); i++) {
                    rutinaSeleccionada.agregarUnEjercicioARutina(ejerciciosElegidos.get(i));
                }

                JfrAvisoPopUp jfrAvisoPopUp = new JfrAvisoPopUp(this, true, "Rutina generada con exito");
            }
            else {
                JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "La rutina no puede tener menos de 3 ejercicios");
            }
        } else {
            if (!rutinaSeleccionada.getRutina().isEmpty()) {
                //la tabla de rutina actual tiene algo pero no se agrego ningun ejercicio
                JfrAvisoPopUp jfrAvisoPopUp = new JfrAvisoPopUp(this, true, "No se agrego ningun ejercicio");
            } else {
                //la tabla de rutina actual esta vacia
                JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se puede crear una rutina vacia");
            }
        }

    }

    private void BotonAgregarEjercicioARutinaActionPerformed(java.awt.event.ActionEvent evt) {
        //Funcionalidad para pasar los ejerciiso de seleccioandos a la lista de la nueva rutina

        int filaSeleccionada = TablaDeEjercicios.getSelectedRow();

        Ejercicio ejercicio;

        String nombreEjercicioElegido = "";

        if (filaSeleccionada != -1 && TablaDeEjercicios.getValueAt(filaSeleccionada, 0) != null) {

            nombreEjercicioElegido = (String) TablaDeEjercicios.getValueAt(filaSeleccionada, 0); // obtengo el nombre
            ejercicio = rutinaSeleccionada.buscarUnEjercicioXNombre(nombreEjercicioElegido); //busco el ejercicio

            DefaultTableModel modeloDatosDefault = (DefaultTableModel) TablaRutinaActual.getModel(); //este es un formateo para poder agregar filas
            if (!ejercicioRepetido(nombreEjercicioElegido)) {
                JfrAgregarSriesYRepsPopUp jfrAgregarSriesYRepsPopUp = new JfrAgregarSriesYRepsPopUp(this, true, ejercicio);//asigno series y ejercicios
                asignarUnEjercicioATablaDeRutinaActual(modeloDatosDefault, ejercicio);//escribo el ejercicio en la tabla
                ejerciciosElegidos.add(ejercicio); //agrego al arraylist stage para luego subirlo a la rutina
            } else {
                JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "El ejercicio ya esta en la rutina");

            }

        } else {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Elija un ejercicio para asignarlo a la rutina");
        }

    }

    private void BotonSacarEjercicioRutinaActionPerformed(ActionEvent evt) {
        int filaSeleccionada = TablaRutinaActual.getSelectedRow();

        DefaultTableModel tableModel = (DefaultTableModel) TablaRutinaActual.getModel();

        if (filaSeleccionada != -1) {
            ejerciciosElegidos.remove(filaSeleccionada);
            tableModel.removeRow(filaSeleccionada);
            System.out.println(ejerciciosElegidos.toString());
        } else {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No haz seleccionado un ejercicio");
        }

    }


    private void SelectorDeObjetivosActionPerformed(java.awt.event.ActionEvent evt) {
        //nada mas se selecciona el objetivo de la rutina
        String eObjetivo = (String) SelectorDeObjetivos.getSelectedItem();

        rutinaSeleccionada.setObjetivo(eObjetivo);
    }

    private void SelectorDeDiasActionPerformed(java.awt.event.ActionEvent evt) {
        //dependiendo el dia seleccionado, se lee la rutina asignada que tiene el cliente


        String diaSeleccionadoOptionBox = (String) SelectorDeDias.getSelectedItem();//el dia seleccionado en el optionbox

        //System.out.println("1"+ diaSeleccionadoOptionBox);

        rutinaSeleccionada = clienteActual.getUnaRutinaEspecifica(EDiasSemana.valueOf(diaSeleccionadoOptionBox));

        //System.out.println("2"+ rutinaSeleccionada);

        String diaRutinaActual = rutinaSeleccionada.getDiaAsignado().toString();//el dia de la rutina actual

        //System.out.println("3"+ diaRutinaActual);


        limpiarTabla((DefaultTableModel) TablaRutinaActual.getModel()); //limpio la tabla
        ejerciciosElegidos.clear();//limpio los ejercicios elegidos


        cargarTablaRutinaActualDependeElDia(EDiasSemana.valueOf(diaSeleccionadoOptionBox));//asigno los elementos

    }

    private void limpiarTabla(DefaultTableModel tablaDefault) {
        tablaDefault.setRowCount(0);
    }

    private void cargarTablaRutinaActualDependeElDia(EDiasSemana diaSeleccionado) {
        DefaultTableModel modeloDeDatosDefault = (DefaultTableModel) TablaRutinaActual.getModel();

        for (Ejercicio ejercicio : rutinaSeleccionada.getRutina()) {
            asignarUnEjercicioATablaDeRutinaActual(modeloDeDatosDefault, ejercicio);
        }

    }


    private void BotonIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);
    }


    private void llenarTablaConEjercicios() {
        //se llena la tabla con ejercicios leidos del JSON

        DefaultTableModel modeloDeDatosDefault = (DefaultTableModel) TablaDeEjercicios.getModel();


        for (Ejercicio ejercicio : ejerciciosJson) {

            //jercicio ejercicioResumido = new Ejercicio(ejercicio.getNombreEjercicio(), ejercicio.getComplejidad(), ejercicio.getMaterialDeTrabajo());
            asignarUnEjercicioATablaDeEjercicios(modeloDeDatosDefault, ejercicio);

        }
    }

    private void asignarUnEjercicioATablaDeEjercicios(DefaultTableModel modeloDeDatos, Ejercicio ejercicioActual) {
        //esta a la tabla de los ejercicios del json
        //String[]datosEjercicio= new String[]{"Nombre", " Complejidad", "Material"};
        String[] datosEjercicios = new String[]{ejercicioActual.getNombreEjercicio(), ejercicioActual.getComplejidad(), ejercicioActual.getMaterialDeTrabajo()};

        modeloDeDatos.addRow(datosEjercicios);

    }

    private void asignarUnEjercicioATablaDeRutinaActual(DefaultTableModel modeloDeDatosDefault, Ejercicio ejercicioActual) {

        //se utiliza defaultTableModel justamente para poder agregar filas, el tableModel normal no te deja
        //es medio tosco crear un string como arreglo, pero es de la unica forma de la que DefaultTableModel acepta para agregar una nueva fila
        String[] datosEjercicio = new String[]{ejercicioActual.getNombreEjercicio(),
                ejercicioActual.getComplejidad(),
                ejercicioActual.getMaterialDeTrabajo(),
                String.valueOf(ejercicioActual.getSeries()),
                String.valueOf(ejercicioActual.getRepeticiones())};

        if ((ejercicioActual.getRepeticiones() != 0 && ejercicioActual.getSeries() != 0)) {
            modeloDeDatosDefault.addRow(datosEjercicio);
        } else {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se puede asignar ejercicios sin series ni repeticiones");

        }
    }

    public boolean ejercicioRepetido(String nombreEjercicio) {
        boolean rta = false;
        for (Ejercicio ejercicios : ejerciciosElegidos) {
            if (ejercicios.getNombreEjercicio().equals(nombreEjercicio)) {
                rta = true;
            }
        }
        return rta;
    }
}


