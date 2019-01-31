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
public class LockedExe extends Estado {
    
    @Override
    public void run(Proceso proceso) {
       notificarEjecucionES(proceso);
    }
    
    public void notificarEjecucionES(Proceso proceso){
        proceso.getObsES().runBloqueado();
    }
    
}
