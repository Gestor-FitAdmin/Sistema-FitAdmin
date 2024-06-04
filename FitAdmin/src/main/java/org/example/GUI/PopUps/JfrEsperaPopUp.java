package org.example.GUI.PopUps;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JfrEsperaPopUp extends JDialog {
    private JProgressBar progressBar;

    public JfrEsperaPopUp(Frame parent, String titulo) {
        super(parent, titulo, true);
        setLayout(new BorderLayout());
        setSize(300, 100);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());

        JLabel label = new JLabel("Por favor espere...", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        add(progressBar, BorderLayout.CENTER);
    }

    public void showWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    public void hideWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();
            }
        });
    }
}