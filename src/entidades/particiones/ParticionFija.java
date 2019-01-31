/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.particiones;

import entidades.proceso.Proceso;

/**
 *
 * @author gasto
 */
public class ParticionFija extends Particion{
    
    public ParticionFija(int tamano) {
        super(tamano);
    }

    @Override
    public Particion cargar(Proceso proceso) {
        setProceso(proceso);
       
        return null;
    }
    
    
    
}
