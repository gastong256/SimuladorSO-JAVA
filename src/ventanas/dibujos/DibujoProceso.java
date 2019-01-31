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
public class DibujoProceso {
    
    private String idP;
    private int posx, posy;
    private static int unidadTamano = 100;
    private int tamanoReal;
    private Color color;

    
    public void pintarProceso(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(getPosx()+3, getPosy()+3, getUnidadTamano(), 50);
        int finReal = getPosx() + getUnidadTamano(); //Ver como usar
        g.setColor(color);
        g.fillRect(getPosx(), getPosy(), getUnidadTamano(), 50); 
    }
    
    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public static int getUnidadTamano() {
        return unidadTamano;
    }

    public static void setUnidadTamano(int unidadTamano) {
        DibujoProceso.unidadTamano = unidadTamano;
    }

    public int getTamanoReal() {
        return tamanoReal;
    }

    public void setTamanoReal(int tamanoReal) {
        this.tamanoReal = tamanoReal;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   
    
    
    
}
