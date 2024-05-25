package org.example.GUI;


import com.dropbox.core.DbxException;
import com.dropbox.core.InvalidAccessTokenException;
import org.example.Modelo.Cliente;
import org.example.API.DropBoxAPI;
import org.example.API.QrAPI;
import org.example.Modelo.Cliente;
import org.example.Modelo.Gimnasio;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;

public class JfrAcceso extends javax.swing.JFrame {

    private javax.swing.JButton BotonBuscarId;
    private javax.swing.JButton BotonIrParaAtras;
    private javax.swing.JButton BotonoGenerarQR;
    private javax.swing.JSpinner ContadorIdUsuario;
    private javax.swing.JLabel MostrarImagenQR;
    private javax.swing.JTable TableSeleccionarClienteQR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private DropBoxAPI dropBoxAPI;



    public JfrAcceso() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSeleccionarClienteQR = new javax.swing.JTable();
        BotonoGenerarQR = new javax.swing.JButton();
        MostrarImagenQR = new javax.swing.JLabel();
        BotonIrParaAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ContadorIdUsuario = new javax.swing.JSpinner();
        BotonBuscarId = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));
        jPanel1.setToolTipText("");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        TableSeleccionarClienteQR.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Id", "Nombre", "Apellido"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableSeleccionarClienteQR);
        if (TableSeleccionarClienteQR.getColumnModel().getColumnCount() > 0) {
            TableSeleccionarClienteQR.getColumnModel().getColumn(0).setResizable(false);
            TableSeleccionarClienteQR.getColumnModel().getColumn(1).setResizable(false);
            TableSeleccionarClienteQR.getColumnModel().getColumn(2).setResizable(false);
        }

        BotonoGenerarQR.setBackground(new java.awt.Color(130, 130, 130));
        BotonoGenerarQR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonoGenerarQR.setForeground(new java.awt.Color(242, 242, 242));
        BotonoGenerarQR.setText("Generar QR");
        BotonoGenerarQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarQRActionPerformed(evt);
            }
        });

        BotonIrParaAtras.setBackground(new java.awt.Color(63, 63, 63));
        BotonIrParaAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrParaAtras.setBorder(null);
        BotonIrParaAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrParaAtrasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("ID del Usuario: ");

        ContadorIdUsuario.setModel(new javax.swing.SpinnerNumberModel());
        ContadorIdUsuario.setMinimumSize(new java.awt.Dimension(70, 22));
        ContadorIdUsuario.setPreferredSize(new java.awt.Dimension(70, 22));
        ContadorIdUsuario.setValue(1);//aparece con el ID 1 por defecto
        //validacion del spinner
        JComponent editor = ContadorIdUsuario.getEditor();
        if (editor instanceof JSpinner.NumberEditor numberEditor)
        {
            //no permite ingresar letras
            JFormattedTextField textField = numberEditor.getTextField();
            DefaultFormatterFactory factory = (DefaultFormatterFactory) textField.getFormatterFactory();
            NumberFormatter formatter = (NumberFormatter) factory.getDefaultFormatter();

            //NumberFormatter para solo aceptar números enteros positivos
            formatter.setAllowsInvalid(false); // No permitir valores inválidos
            formatter.setCommitsOnValidEdit(true); // Confirmar el valor en cada edición válida
            NumberFormat format = NumberFormat.getIntegerInstance();
            formatter.setFormat(format);
            formatter.setMinimum(1); // Establecer el valor mínimo en 1 //el 0 es administrador
        }
        BotonBuscarId.setBackground(new java.awt.Color(130, 130, 130));
        BotonBuscarId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonBuscarId.setForeground(new java.awt.Color(242, 242, 242));
        BotonBuscarId.setText("Buscar");
        BotonBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(BotonIrParaAtras)
                                                .addGap(49, 49, 49)
                                                .addComponent(MostrarImagenQR, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ContadorIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(BotonBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jLabel3)))
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(BotonoGenerarQR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ContadorIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(BotonBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonoGenerarQR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(245, 245, 245)
                                                .addComponent(BotonIrParaAtras))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(MostrarImagenQR, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(7, Short.MAX_VALUE))
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
    private void verificarCaracteresEnSpinner(java.awt.event.ActionEvent evt)
    {
        ContadorIdUsuario.setModel(new javax.swing.SpinnerNumberModel());
    }


    private void BotonIrParaAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrMenuPrincipal prin = new JfrMenuPrincipal();
        prin.setVisible(true);
    }
    private void BotonGenerarQRActionPerformed(java.awt.event.ActionEvent evt) {

        Gimnasio gym = GUIEnvoltorio.getGimnasio();//agarro el gimnasio entero
        QrAPI qrAPI = new QrAPI();//preparo un QR para usarlo despues
        Integer idSocioSeleccionado;
        Integer filaSeleccionada = TableSeleccionarClienteQR.getSelectedRow();//agarro la fila que seleccionaron con el mouse
        String rutaQRaGenerar = "QRaGenerar";


        if(filaSeleccionada != -1 ) //si no selecciono nada retorna -1
        {

            idSocioSeleccionado= (Integer) TableSeleccionarClienteQR.getValueAt(filaSeleccionada, 0); //obtengo el id en la columna 0
            Cliente clienteAux= GUIEnvoltorio.getGimnasio().buscar(idSocioSeleccionado); // busco el cliente
            if (clienteAux != null || idSocioSeleccionado != null)
            {

                try {
                    //intento entrar al api
                    dropBoxAPI=new DropBoxAPI();

                    gym.crearPDFParaQR(clienteAux);//GENERA LOS DATOS PARA LUEGO SUBIR EL PDF A DB
                    dropBoxAPI.subirPDF(rutaQRaGenerar);//nombre del archivo de donde se genero el PDF del cliente

                    String url = dropBoxAPI.obtenerURL(rutaQRaGenerar);
                    qrAPI.generarQr(url);
                    // Ruta relativa a la imagen en la carpeta del proyecto
                    String rutaImagen = "qrCliente.jpg";

                    // Cargar la imagen desde la ruta especificada

                    // Eliminar cualquier posible caché de la imagen al recargarla
                    BufferedImage bufferedImage = ImageIO.read(new File(rutaImagen));
                    ImageIcon icono = new ImageIcon(bufferedImage);
                    // Establecer el icono en el JLabel
                    MostrarImagenQR.setIcon(null); // Limpiar el icono anterior
                    MostrarImagenQR.setIcon(icono); // Establecer el nuevo icono
                    MostrarImagenQR.revalidate(); // Actualizar el JLabel
                    MostrarImagenQR.repaint(); // Repintar el JLabel

                }
                catch (DbxException e)
                {
                    //url invalida
                    e.printStackTrace();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (NullPointerException e)
                {
                    System.out.println("No estamos conectados a la api por eso el cliente esta vacio");
                } catch (IOException e) {
                    System.out.println("Archivo roto");
                }
            }
            else
            {
                JfrErrorPopUp errorPopUp = new JfrErrorPopUp("Busque un cliente para generar el QR");
            }
        }
        else
        {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp("Seleccione un cliente para generar el QR");
        }


    }
    private void BotonBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {
        // busco el id que esta seleccionado en el contador y lo muestro en la tabla

        Integer idSocioLeido=(Integer) ContadorIdUsuario.getValue();

        idSocioLeido++;

        for (int i=0; i < TableSeleccionarClienteQR.getColumnCount(); i++)
        {
            Cliente cliente= GUIEnvoltorio.getGimnasio().buscar(idSocioLeido);

            //limpio la tabla
            TableSeleccionarClienteQR.setValueAt(null,i,0);
            TableSeleccionarClienteQR.setValueAt(null,i,1);
            TableSeleccionarClienteQR.setValueAt(null,i,2);

            if (cliente != null)
            {
                TableSeleccionarClienteQR.setValueAt(cliente.getIdCliente(),i,0);
                TableSeleccionarClienteQR.setValueAt(cliente.getNombre(),i,1);
                TableSeleccionarClienteQR.setValueAt(cliente.getApellido(),i,2);
            }
            idSocioLeido--;
        }


    }


    private void MostrarImagenQRActionPerformed(java.awt.event.ActionEvent evt) {
       // Cliente clientePrueba = new Cliente("Leo", "Caimmi", "46012540", "masculino", 75.5, 182.5, "09/07/2004", "leonardocaimmi1@gmail.com", true);


    }

    private Cliente TableSeleccionarClienteQRActionPerformed(java.awt.event.ActionEvent evt,Gimnasio gym)
    {
        int selectedRow = TableSeleccionarClienteQR.getSelectedRow();//agarro la fila que seleccionaron con el mouse

        int idAbuscar = (int) TableSeleccionarClienteQR.getValueAt(selectedRow, 0);//agarro el id del seleccionado
        Cliente clienteAux;
        clienteAux = gym.buscar(idAbuscar);//me devuelve el cliente

        return clienteAux;
    }


}
