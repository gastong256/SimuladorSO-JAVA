/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas.dibujos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author gasto
 */
public class PanelDibujo extends JPanel{
    
        ArrayList<DibujoProceso> listaProcesos = null;
DibujoClock clock = null;
ArrayList<DibujoProceso> listaEntradaSalida = null;

            private int tamanoPanel = 0;
            
            
            public PanelDibujo(){
                setListaProcesos(new ArrayList<>());
                setListaEntradaSalida(new ArrayList<>());
                setBackground(Color.WHITE);
            }
            
            public void nuevoProceso(){
        setTamanoPanel(getTamanoPanel() + 100);
        this.setPreferredSize(new Dimension(getTamanoPanel() + 100,400));
        repaint();
    }
            public void nuevoClock(){
                repaint();
            }
   
            @Override
    public void paint(Graphics g){
        super.paint(g);
        for (DibujoProceso cadaProceso : getListaProcesos()) {
            cadaProceso.pintarProceso(g);
        }
        if(clock != null){
        clock.pintarLinea(g);
        }
        if(! getListaEntradaSalida().isEmpty()){
            for (DibujoProceso dibujo : getListaEntradaSalida()) {
                dibujo.pintarProceso(g);
            }
        }
        
    }

    public ArrayList<DibujoProceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<DibujoProceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public int getTamanoPanel() {
        return tamanoPanel;
    }

    public void setTamanoPanel(int tamanoPanel) {
        this.tamanoPanel = tamanoPanel;
    }

    public DibujoClock getClock() {
        return clock;
    }

    public void setClock(DibujoClock clock) {
        this.clock = clock;
    }

    public ArrayList<DibujoProceso> getListaEntradaSalida() {
        return listaEntradaSalida;
    }

    public void setListaEntradaSalida(ArrayList<DibujoProceso> listaEntradaSalida) {
        this.listaEntradaSalida = listaEntradaSalida;
    }
    
    

            
    
    
}
