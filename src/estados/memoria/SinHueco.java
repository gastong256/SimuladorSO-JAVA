/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados.memoria;

import entidades.memoria.Estado;
import entidades.memoria.Memoria;
import entidades.particiones.Particion;
import java.util.ArrayList;

/**
 *
 * @author gasto
 */
public class SinHueco extends Estado {

    @Override
    public int buscarFit(int tamanoProceso, ArrayList<Particion> listaLibres) {
       return -1;
               }

    


    
}
