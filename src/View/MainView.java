package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
    public MainView() {
        JFrame framePrincipal = new JFrame("EP1");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());

        JButton button1 = new JButton("Productos existentes");
        JButton button2 = new JButton("Agregar producto");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarView();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarView();
            }
        });

        panelPrincipal.add(button1);
        panelPrincipal.add(button2);

        framePrincipal.add(panelPrincipal);
        framePrincipal.setVisible(true);
    }
}
