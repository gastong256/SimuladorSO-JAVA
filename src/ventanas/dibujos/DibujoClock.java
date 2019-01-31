/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas.dibujos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gasto
 */
public class DibujoClock {
    private int posx;
    private int fin;
    
    public void pintarLinea(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(getPosx(), 140, fin, 140);
        
            for (int i = getPosx(); i <= fin; i+=100) {
                g.drawLine(i, 135, i, 145);
                int valor = (i / 100);
                String v = "" + valor;
                g.drawString(v, i, 155);
            }
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

 
    
    
    
}
