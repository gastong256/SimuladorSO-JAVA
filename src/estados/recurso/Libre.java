/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados.recurso;


import entidades.proceso.Proceso;
import entidades.recurso.Estado;
import entidades.recurso.Recurso;

/**
 *
 * @author gasto
 */
public class Libre extends Estado {

    @Override
    public boolean tryAsignar(Proceso proceso, Recurso recurso) {
    recurso.setProcesoRunning(proceso);
    recurso.setEstadoActual(new Ocupado());
    
    return true;
    }

    @Override
    public boolean withOwner() {
      return false;
    }

    @Override
    public String getOwner() {
       return "";
    }
    
}
