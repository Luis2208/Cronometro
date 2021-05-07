/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciommb009;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author CC02
 */
public class Ventana extends JFrame {

    private Grafico grafico;
    private Cronometro cron;

    public JButton btnIniciar;
    public JButton btnDetener;
    public JButton btnReiniciar;

    public  Ventana() {

        setTitle("Ejercicio 9 - Cronometro");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cron = new Cronometro();
        grafico = new Grafico(cron);
        cron.setGrafico(grafico);
        
        setLayout(new BorderLayout());
        initControles();
        
        add(BorderLayout.CENTER,grafico);
    }

    private void initControles() {
        btnIniciar = new JButton("Iniciar");
        btnDetener = new JButton("Detener");
        btnReiniciar = new JButton("Reiniciar");

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cron.iniciar();
            }
        });

        btnDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cron.detener();
            }
        });

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cron.reiniciar();
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(btnIniciar);
        panel.add(btnDetener);
        panel.add(btnReiniciar);
        
        add(BorderLayout.NORTH, panel);
    }

}
