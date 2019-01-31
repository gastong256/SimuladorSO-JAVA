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
public class ParticionVariable extends Particion {
    
    public ParticionVariable(int tamano) {
        super(tamano);
    }
    
    //metodo que carga un proceso en la particion, al ser variable
    //el mismo devuelve una particion nueva del tamaño del hueco que dejo el proceso
    @Override
    public Particion cargar(Proceso proceso){
        
        setProceso(proceso);
        
        int tamanoNuevo = getTamano() - getProceso().getTamano();
        if(tamanoNuevo > 0){
            setTamano(proceso.getTamano());
            Particion nueva = new ParticionVariable(tamanoNuevo);
            
            return nueva;
        }
        return null;
    }
    
}
