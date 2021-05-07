/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciommb009;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author CC02
 */
public class Cronometro implements ActionListener {

    private Timer timer;
    private int horas;
    private int minutos;
    private int segundos;
    private Grafico grafico;

    public Cronometro() {
        timer = new Timer(10, this);// va a iniciar el metodo action perrformad
    }

    public void setGrafico(Grafico grafico) {
        this.grafico = grafico;
    }

    public void iniciar() { //inicia el cronometro
        timer.start();
    }

    public void detener() {// detiende el cronometro
        timer.stop();
    }

    public void reiniciar() { //reinicia no detiene el cronometro, reinicia las variables a cero
        horas = 0;
        minutos = 0;
        segundos = 0;
        grafico.repaint();

    }

    private void procesar() { //incrementa los segundos
        segundos++;
        if (segundos > 59) {
            minutos++;
            segundos = 0;
        }
        if (minutos > 59) {
            horas++;
            minutos = 0;
            segundos = 0;
        }

    }

    public void mostrar(Graphics2D g) {// recibe un objeto de la clase graphics
        StringBuilder sb = new StringBuilder();
        sb.append(horas).append(":");//le pegamos las horas

        if (minutos < 10) {//antepone los minutos
            sb.append("0");
        }
        sb.append(minutos).append(":");
        if (segundos < 10) {
            sb.append(0);
        }
        sb.append(segundos);

        g.setColor(Color.WHITE);
        
        Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        FontMetrics fn = grafico.getFontMetrics(fuente);
        int len = fn.stringWidth(sb.toString());
        int pos = (grafico.getWidth()/2) - (len /2);
        g.setFont(fuente);
        g.drawString(sb.toString(), pos, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        procesar();
        grafico.repaint();
    }

}
