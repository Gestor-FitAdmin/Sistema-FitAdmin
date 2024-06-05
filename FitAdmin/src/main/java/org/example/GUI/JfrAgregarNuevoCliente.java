package org.example.GUI;

import org.example.Enum.ESexo;
import org.example.GUI.PopUps.JfrAvisoPopUp;
import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;
import org.example.Modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrAgregarNuevoCliente extends JFrame {

    private JButton BotonIrAtras;
    private JComboBox<String> SelectorDeActividades;
    private JTextField TextAreaApellido;
    private JTextField TextAreaDNI;
    private JTextField TextAreaNombre;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField TextAreaFechaDeNacimiento;
    private JTextField jTextField2;
    private JTextField TextAreaAltura;
    private JTextField TextAreaPeso;
    private JTextField TextAreaEmail;
    private JComboBox<String> selectorDeSexo;

    public JfrAgregarNuevoCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());
    }


    private void initComponents() {

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        TextAreaNombre = new JTextField();
        TextAreaApellido = new JTextField();
        selectorDeSexo = new JComboBox<>();
        TextAreaDNI = new JTextField();
        TextAreaAltura = new JTextField();
        TextAreaPeso = new JTextField();
        TextAreaEmail = new JTextField();
        TextAreaFechaDeNacimiento = new JTextField();
        SelectorDeActividades = new JComboBox<>();
        jButton1 = new JButton();
        BotonIrAtras = new JButton();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                // Crear el panel de opciones con los botones personalizados
                Object[] options = {"Si", "No"};
                int option = JOptionPane.showOptionDialog(
                        JfrAgregarNuevoCliente.this,
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


        jPanel1.setBackground(new Color(63, 63, 63));
        jPanel1.setToolTipText("");

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new Color(242, 242, 242));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(242, 242, 242));
        jLabel3.setText("Apellido");

        jLabel4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(242, 242, 242));
        jLabel4.setText("DNI");

        jLabel5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(242, 242, 242));
        jLabel5.setText("Sexo");

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(242, 242, 242));
        jLabel6.setText("Peso");

        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new Color(242, 242, 242));
        jLabel7.setText("Altura");

        jLabel8.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new Color(242, 242, 242));
        jLabel8.setText("Fecha de nacimiento");

        jLabel9.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new Color(242, 242, 242));
        jLabel9.setText("E-Mail");

        jLabel10.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new Color(242, 242, 242));
        jLabel10.setText("Actividad");

        TextAreaNombre.setBackground(new Color(130, 130, 130));
        TextAreaNombre.setForeground(new Color(242, 242, 242));
        TextAreaNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextAreaNombreActionPerformed(evt);
            }
        });

        TextAreaApellido.setBackground(new Color(130, 130, 130));
        TextAreaApellido.setForeground(new Color(242, 242, 242));
        TextAreaApellido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextAreaApellidoActionPerformed(evt);
            }
        });

        selectorDeSexo.setBackground(new Color(130, 130, 130));
        selectorDeSexo.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        selectorDeSexo.setForeground(new Color(242, 242, 242));
        selectorDeSexo.setModel(new DefaultComboBoxModel<>(new String[]{"Masculino", "Femenino"}));
        selectorDeSexo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectorDeSexoActionPerformed(evt);
            }
        });

        TextAreaDNI.setBackground(new Color(130, 130, 130));
        TextAreaDNI.setForeground(new Color(242, 242, 242));
        TextAreaDNI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextAreaDNIActionPerformed(evt);
            }
        });


        TextAreaAltura.setBackground(new Color(130, 130, 130));
        TextAreaAltura.setForeground(new Color(242, 242, 242));

        TextAreaPeso.setBackground(new Color(130, 130, 130));
        TextAreaPeso.setForeground(new Color(242, 242, 242));

        TextAreaEmail.setBackground(new Color(130, 130, 130));
        TextAreaEmail.setForeground(new Color(242, 242, 242));

        TextAreaFechaDeNacimiento.setBackground(new Color(130, 130, 130));
        TextAreaFechaDeNacimiento.setForeground(new Color(242, 242, 242));
        TextAreaFechaDeNacimiento.setText("dd-MM-yyyy");

        SelectorDeActividades.setBackground(new Color(130, 130, 130));
        SelectorDeActividades.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        SelectorDeActividades.setForeground(new Color(242, 242, 242));
        SelectorDeActividades.setModel(new DefaultComboBoxModel<>(new String[]{"Musculacion"}));
        SelectorDeActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelectorDeActividadesActionPerformed(evt);
            }
        });

        jButton1.setBackground(new Color(130, 130, 130));
        jButton1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new Color(242, 242, 242));
        jButton1.setText("Inscribir");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new Color(63, 63, 63));
        BotonIrAtras.setIcon(new ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setBorder(null);
        BotonIrAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIrAtrasActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(85, 85, 85))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(101, 101, 101))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(94, 94, 94))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(jLabel10))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(SelectorDeActividades, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(TextAreaPeso, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextAreaNombre, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextAreaDNI, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(TextAreaFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(36, 36, 36)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(selectorDeSexo, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaApellido, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaAltura, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(TextAreaEmail, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(81, 81, 81)
                                                                                .addComponent(jLabel9))))
                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonIrAtras))))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectorDeSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaPeso, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextAreaFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SelectorDeActividades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonIrAtras)
                                .addGap(19, 19, 19))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void TextAreaApellidoActionPerformed(ActionEvent evt)
    {
        // TODO add your handling code here:
    }

    private void SelectorDeActividadesActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        boolean flag = true;  // Inicializa como true
        Gimnasio gym = GUIEnvoltorio.getGimnasio();

        double altura=0;
        double peso=0;
        int idSocio = proximoIdSocio();

        String actividadInscripto = (String) SelectorDeActividades.getSelectedItem();

        String sexoString= (String) selectorDeSexo.getSelectedItem();
        assert sexoString != null;
        ESexo sexo= ESexo.valueOf(sexoString.toUpperCase());

        LocalDate fecha = null;
        
        String posibleError="";



        //validar altura
        try
        {
            altura= Double.parseDouble(TextAreaAltura.getText());

        }
        catch (NumberFormatException e){
            flag = false;
           posibleError= posibleError.concat("Ingrese un valor a la altura.");
//            JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp(this,true,"Ingrese un valor a la altura");
        }
        if(gym.verificarAlturaIngresadoCliente(altura))//si no esta en los rangos delimitados
        {
            posibleError= posibleError.concat("Ingrese una altura valida. ");
            TextAreaAltura.setText(null);
            flag = false;

        }

        //validar peso

        try
        {
          peso= Double.parseDouble(TextAreaPeso.getText());

        }
        catch (NumberFormatException e){
            flag = false;
            posibleError= posibleError.concat("Ingrese un valor al peso. ");
            //JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp(this,true,"Ingrese un valor al peso");
        }
        if(gym.verificarPesoIngresadoCliente(peso))//si no esta en los rangos delimitados
        {
            posibleError= posibleError.concat("Ingrese un peso valido. ");
            TextAreaPeso.setText(null);
            flag = false;
        }

        // Validar nombre
        if (verificarSiContieneNumero(TextAreaNombre.getText())) {
            posibleError= posibleError.concat("No puede ingresar digitos en el nombre. ");
            //JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this,true,"No puede ingresar digitos en el nombre");
            TextAreaNombre.setText(null);
            flag = false;
        }

        // Validar apellido
        if (verificarSiContieneNumero(TextAreaApellido.getText())) {
            posibleError= posibleError.concat("No puede ingresar digitos en el apellido. ");
            //JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this,true,"No puede ingresar digitos en el apellido");
            TextAreaApellido.setText(null);
            flag = false;
        }

        // Validar email
        if (verificarArroba(TextAreaEmail.getText())) {
            posibleError= posibleError.concat("Debe poner una e-mail valido (@). ");
            //JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this,true,"Olvido poner su @ en el e-Mail");
            TextAreaEmail.setText(null);
            flag = false;
        }
        //Validar DNI

        if (GUIEnvoltorio.getGimnasio().verificarDNIExistente(TextAreaDNI.getText())||verificarTamDNI(TextAreaDNI.getText()))//si ya existe el DNI en el sistema o si no cumple con los requisitos
        {
            posibleError= posibleError.concat("DNI ya existente o es invalido. ");
           // JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this,true,"DNI ya existente o es invalido");
            TextAreaDNI.setText(null);
            flag = false;
        }

        //validar fechaDeNacimiento
        String textoFecha= TextAreaFechaDeNacimiento.getText();
        textoFecha=  textoFecha.replace("/","-");
        if (verificarFechaDeNacimiento(textoFecha))
        {

            DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd-MM-yyyy");

            fecha= LocalDate.parse(textoFecha,formatoFecha);

        }else {
            flag=false;
            posibleError= posibleError.concat("Fecha de nacimiento invalida. ");
            //JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp(this,true,"Fecha de nacimiento invalida");
        }


        //si hubo algun error, salta un popup con todos los errores
        if (!posibleError.isEmpty())
        {
            JfrErrorPopUp jfrErrorPopUp=new JfrErrorPopUp(this,true,posibleError);
        }

        //validar

        if(flag)//si pasa las validaciones
        {

            // Solo si flag sigue siendo true
            Cliente cliente = new Cliente(
                    TextAreaNombre.getText(),
                    TextAreaApellido.getText(),
                    TextAreaDNI.getText(),
                    sexo,
                    peso,
                    altura,
                    fecha,
                    TextAreaEmail.getText(),
                    true
            );

            cliente.agregarActividadACliente(actividadInscripto);
            gym.agregar(cliente);

            JfrAvisoPopUp jfrAvisoPopUp= new JfrAvisoPopUp(this,true,"Cliente creado con exito");
            TextAreaPeso.setText("");
            TextAreaAltura.setText("");
            TextAreaDNI.setText("");
            TextAreaApellido.setText("");
            TextAreaNombre.setText("");
            TextAreaFechaDeNacimiento.setText("");
            TextAreaEmail.setText("");
        }



    }

    public int proximoIdSocio(){
        return 1;
    }

    public void TextAreaNombreActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void TextAreaDNIActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void selectorDeSexoActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField7ActionPerformed(ActionEvent evt) {
        // peso
    }

    private void jTextField6ActionPerformed(ActionEvent evt) {
        // Altura
    }

    private void jTextField8ActionPerformed(ActionEvent evt) {
        // Email
    }

    private void jTextField10ActionPerformed(ActionEvent evt) {
        // Fecha de nacimeinto
    }

    private void BotonIrAtrasActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        JfrCliente cliente = new JfrCliente();
        cliente.setVisible(true);
    }
    protected boolean verificarSiContieneNumero(String aComparar)
    {
        boolean rta = false;
        for (int i = 0; i < aComparar.length(); i++)
        {
            if (Character.isDigit(aComparar.charAt(i)))
            {
                rta = true;
            }
        }
        return rta;
    }
    protected boolean verificarArroba(String aComparar)
    {
        boolean rta = false;

           if(!aComparar.contains("@"))
           {
            rta = true;
           }
        return rta;
    }

    protected boolean verificarTamDNI(String aComparar)
    {
        boolean rta = false;
        //String aVerificar = TextAreaDNI.getText();
        if(aComparar.length()<7 ||aComparar.length()>8)
        {
            rta = true;
        }
        return rta;
    }

    protected boolean verificarFechaDeNacimiento(String fechaRecibida)
    {
        boolean flag=false;
        //System.out.println(fechaRecibida);



        DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate fechaCalculada= LocalDate.parse(fechaRecibida,formatoFecha);
            int max=100;
            int min=10;
            int calculo= LocalDate.now().getYear()-fechaCalculada.getYear();

            if (calculo > min && calculo < max)
            {
                flag=true;
            }
        }
        catch (DateTimeParseException e)
        {
            System.out.println("Fecha invalida");
            //el formato no es el requerido
        }
        catch (Exception e)
        {

        }
        return flag;
    }

}


