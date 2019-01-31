/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.recurso;

import entidades.proceso.Proceso;



/**
 *
 * @author gasto
 */
public abstract class Estado {
    
    public abstract boolean tryAsignar(Proceso proceso, Recurso recurso);
    public abstract boolean withOwner();
    
    public abstract String getOwner();
    
}
