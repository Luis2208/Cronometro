/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciommb009;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author CC02
 */
public class Grafico extends JPanel {

    private Cronometro cron;

    public Grafico(Cronometro cron) {
        this.cron = cron;
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        Graphics2D g2d = (Graphics2D)  g;
        
        cron.mostrar(g2d);
        g2d.dispose();
    }
    
    
    

}
