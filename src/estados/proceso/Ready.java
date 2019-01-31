/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados.proceso;

import entidades.proceso.Estado;
import entidades.proceso.Proceso;

/**
 *
 * @author gasto
 */
public class Ready extends Estado {
    
    @Override
    public void run(Proceso proceso) {
       notificarListo(proceso);
    }
    
    public void notificarListo(Proceso proceso){
        proceso.getObsPlanificador().cargarListo();
    }
    
}
