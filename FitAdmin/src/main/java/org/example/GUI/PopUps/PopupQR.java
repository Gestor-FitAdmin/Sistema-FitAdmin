package org.example.GUI.PopUps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public class PopupQR extends JFrame {
    public PopupQR() {
        setTitle("Popup con código QR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());

        mostrarPopup();
    }

    private void mostrarPopup() {
        JDialog popup = new JDialog(this, "Código QR", true);
        popup.setLayout(new BorderLayout());
        popup.setSize(300, 390);
        popup.setLocationRelativeTo(this); // Centra el popup respecto a la ventana principal

        // Panel para el texto y el código QR
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(63, 63, 63)); // Establece el color de fondo

        // Texto sobre el código QR
        JLabel lblTextoQR1 = new JLabel("1° Paso: Scanear QR");
        JLabel lblTextoQR2 = new JLabel("2° Poner DNI de Titulo");
        JLabel lblTextoQR3 = new JLabel("3° Adjuntar foto de perfil");
        JLabel lblTextoQR4 = new JLabel("4° Enviar Mail");

        // Establece el color de texto y la fuente
        Color textColor = new Color(242, 242, 242);
        Font font = new Font("Segoe UI", Font.BOLD, 14);

        lblTextoQR1.setForeground(textColor);
        lblTextoQR2.setForeground(textColor);
        lblTextoQR3.setForeground(textColor);
        lblTextoQR4.setForeground(textColor);

        lblTextoQR1.setFont(font);
        lblTextoQR2.setFont(font);
        lblTextoQR3.setFont(font);
        lblTextoQR4.setFont(font);

        // Alinea el texto al centro horizontalmente
        lblTextoQR1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTextoQR2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTextoQR3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTextoQR4.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Establece los márgenes
        lblTextoQR1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        lblTextoQR4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Sin margen inferior para este label

        // Código QR
        ImageIcon qrIcon = new ImageIcon("FitAdmin/src/main/resources/Images/QrEnviarMailCliente.png"); // Carga la imagen del código QR
        JLabel lblQR = new JLabel(qrIcon);
        lblQR.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblQR.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega un margen de 20px

        // Contenedor del QR con margen inferior
        JPanel qrPanel = new JPanel();
        qrPanel.setBackground(new Color(63, 63, 63)); // Establece el color de fondo
        qrPanel.setLayout(new BoxLayout(qrPanel, BoxLayout.Y_AXIS));
        qrPanel.add(lblQR);

        // Agrega los componentes al panel
        panel.add(lblTextoQR1);
        panel.add(lblTextoQR2);
        panel.add(lblTextoQR3);
        panel.add(lblTextoQR4);
        panel.add(qrPanel);

        popup.add(panel, BorderLayout.CENTER);
        popup.setVisible(true);
    }

}
