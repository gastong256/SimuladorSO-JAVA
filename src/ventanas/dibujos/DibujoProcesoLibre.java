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
public class DibujoProcesoLibre extends DibujoProceso {
    
    
    @Override
    public void pintarProceso(Graphics g){
        super.pintarProceso(g);
        g.setColor(Color.BLACK);
        g.drawRect(getPosx(), getPosy(), getUnidadTamano(), 50);
        for (int i = getPosx(); i < getPosx() + 100; i+=3) {
            g.drawLine(i, getPosy(), i, getPosy()+50);
        }
        
    }
    
}
