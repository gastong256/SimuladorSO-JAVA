/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.administrador;

import entidades.memoria.Memoria;
import entidades.particiones.Particion;
import java.util.ArrayList;

/**
 *
 * @author gasto
 */
public class WorstFit extends Administrador {

    public WorstFit(Memoria memoria) {
        super(memoria);
    }

    @Override
    public ArrayList<Particion> organizarLibres() {
    ArrayList<Particion> listaLibres = new ArrayList<>();
   for (Integer indice : getMemoria().listaParticionesLibre()) {
            listaLibres.add(getMemoria().getListaParticiones().get(indice));
        }
   getMemoria().ordenarFitsMayorMenor(listaLibres);
        return listaLibres;    
    
    }
    
}
