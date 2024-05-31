package org.example.GUI;

import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.Main;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrLogIn extends javax.swing.JFrame {

    //atributos
    private javax.swing.JButton BotonIngreso;
    private javax.swing.JPasswordField TextAreaContrasena;
    private javax.swing.JTextField TextAreaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;


    public JfrLogIn() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());

    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextAreaUsuario = new javax.swing.JTextField();
        TextAreaContrasena = new javax.swing.JPasswordField();
        BotonIngreso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proyecto 3er Cuatrimestre");
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 16));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Inicio de Sesión");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Usuario :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Contraseña :");

        TextAreaUsuario.setForeground(new java.awt.Color(100, 100, 100));
        TextAreaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaUsuarioActionPerformed(evt);
            }
        });

        TextAreaContrasena.setBackground(new java.awt.Color(242, 242, 242));
        TextAreaContrasena.setForeground(new java.awt.Color(100, 100, 100));
        TextAreaContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAreaContrasenaActionPerformed(evt);
            }
        });

        BotonIngreso.setBackground(new java.awt.Color(63, 63, 63));
        BotonIngreso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonIngreso.setForeground(new java.awt.Color(242, 242, 242));
        BotonIngreso.setText("Ingresar");
        BotonIngreso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 2, true));
        BotonIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresoActionPerformed();
            }
        });

        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("By: Caimmi Leonardo, Golisciano Fabrizio, Procelli Facundo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(232, 232, 232))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BotonIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(TextAreaContrasena)
                                                                        .addComponent(TextAreaUsuario))
                                                                .addGap(33, 33, 33))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(TextAreaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(TextAreaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addComponent(BotonIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addContainerGap())
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        escuchadorParaLasTeclas(TextAreaUsuario);
        escuchadorParaLasTeclas(TextAreaContrasena);
        pack();
    }// </editor-fold>

    private void escuchadorParaLasTeclas(JTextField jTextField) {
        jTextField.setFocusable(true);
        jTextField.requestFocusInWindow();

        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    BotonIngresoActionPerformed();
                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    BotonIngresoActionPerformed();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //nada
            }
        });
    }


    private void TextAreaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {


    }

    private void BotonIngresoActionPerformed() {

        String usuario = TextAreaUsuario.getText();
        char[] contrasenaRecibida = TextAreaContrasena.getPassword();
        String contrasena = new String(contrasenaRecibida);

        if (validacion(usuario, contrasena)) {

            TextAreaUsuario.setText("");
            TextAreaContrasena.setText("");

            this.setVisible(false);
            JfrMenuPrincipal menu = new JfrMenuPrincipal();
            menu.setVisible(true);

        } else {
            String mensaje = null;


            if (!gimnasio.getUsuario().equals(usuario)) {
                mensaje = "Usuario incorrecto!";

            } else if (!gimnasio.getContrasenia().equals(contrasena)) {
                mensaje = "Contraseña incorrecta!";

            }
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, mensaje);

        }

    }

    public boolean validacion(String usuario, String contrasena) {
        boolean flag = false;

        if (GUIEnvoltorio.getGimnasio().getContrasenia().equals(contrasena) && Main.gimnasio.getUsuario().equals(usuario)) {
            flag = true;
        }
        return flag;
    }

    private void TextAreaContrasenaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void enviarSaludosDeCumpleanos() {
        Gimnasio gimnasio = GUIEnvoltorio.getGimnasio(); // Accedo al gimansio
        ArrayList<String> localDates = leerArchivoFechas(); // Leo los elementos del archivo y los meto en el arraylist
        HashMap<Integer, Cliente> integerClienteHashMap = gimnasio.getClientes();

        Set<Map.Entry<Integer, Cliente>> entrySet = integerClienteHashMap.entrySet();
        Iterator<Map.Entry<Integer, Cliente>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, Cliente> dato = iterator.next();
            Cliente cliente = dato.getValue();
            for(String fecha : localDates){
                if(fecha.equals(cliente.getFechaDeNacimiento())){
                    //todo: Hay que comparar las fechas, si son iguales, sigo con el siguiente,
                    // si son diferentes comparo la fecha esa con la fecha actual y si son iguales mando mail, sino paso
                }
            }

        }
    }

    static ArrayList<String> leerArchivoFechas() {
        ArrayList<String> localDates = new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("fechas.bin");
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                LocalDate fecha = (LocalDate) objectInputStream.readObject();
                localDates.add(fecha.toString());
            }
        }catch ( FileNotFoundException e){
            //todo: hay que mostrar pop up en metodos static
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return localDates;

    }
    static void grabarArchvioFechas() {
        ObjectOutputStream objectOutputStream = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("fechas.bin");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            String fechaFormateada = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            objectOutputStream.writeObject(fechaFormateada);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}