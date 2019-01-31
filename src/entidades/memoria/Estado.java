/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.memoria;

import entidades.particiones.Particion;
import java.util.ArrayList;



/**
 *
 * @author gasto
 */
public abstract class Estado {
    
    public abstract int buscarFit(int tamanoProceso, ArrayList<Particion> listaLibres);
    
    
}
