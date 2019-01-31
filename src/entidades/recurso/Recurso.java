/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.recurso;

import entidades.proceso.Proceso;
import estados.recurso.ConPropietario;
import estados.recurso.Libre;

/**
 *
 * @author gasto
 */
public class Recurso {
    
    private Proceso procesoRunning;
    private String tag;
    private Estado estadoActual;

    public Recurso(){
        setProcesoRunning(null);
        setEstadoActual(new Libre());
        setTag("");
    }
    
    public boolean hasOwner(){
        return getEstadoActual().withOwner();
    }
    
    public boolean asignar(Proceso proceso){
        return getEstadoActual().tryAsignar(proceso, this);
    }
    
    public void work(){
        getProcesoRunning().consumirRafaga();
    }
    
    public Proceso liberar(){
        Proceso saliente = getProcesoRunning();
       
        
        setProcesoRunning(null);
   
        return saliente;
    }
    
    //metodo que devuelve true o false si el recurso esta cargado
    public boolean isFree(){
        return getProcesoRunning() == null;
    }
    
    //-----Setter and getter
    public Proceso getProcesoRunning() {
        return procesoRunning;
    }

    public void setProcesoRunning(Proceso procesoRunning) {
        this.procesoRunning = procesoRunning;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    
}
