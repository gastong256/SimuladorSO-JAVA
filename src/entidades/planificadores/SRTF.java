/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.planificadores;

import entidades.proceso.Proceso;
import entidades.recurso.Recurso;
import estados.cola.Cargada;
import estados.cola.Vacia;
import estados.proceso.Dead;
import estados.proceso.Exe;
import estados.proceso.LockedReady;
import estados.proceso.Ready;
import estados.recurso.ConPropietario;
import estados.recurso.Libre;

/**
 *
 * @author gasto
 */
public class SRTF extends Planificador{

    public SRTF(Recurso recurso) {
        super(recurso);
    }

    @Override
    public void organizarCola(Proceso proceso) {
    
    getColaListos().encolar(proceso);
        
        
         proceso.setEstadoActual(new Ready());
        getColaListos().setEstadoActual(new Cargada());
        
    }
    
    @Override
    public void cargarListo(){
        getColaListos().ordenar();
        if(getRecurso().asignar(getColaListos().first())){
            getColaListos().first().setEstadoActual(new Exe());
            getColaListos().desencolar();
            
            if(getColaListos().getListaProcesos().isEmpty()){
                getColaListos().setEstadoActual(new Vacia());
            }
        }
    }

    @Override
    public void runEjecutando(){
        Proceso saliente = ejecutar();
        if(saliente != null){
           if(saliente.isOver()){
               System.out.println(saliente.getIdP() + " termino !!");
               saliente.setEstadoActual(new Dead());
               getRecurso().setEstadoActual(new Libre());
              
           }  else {
               getRecurso().setEstadoActual(new Libre());
               saliente.setEstadoActual(new LockedReady());
               notificarBloqueo(saliente);
           } 
        }
    }
    
    @Override
    public Proceso ejecutar() {
        if(getRecurso().getProcesoRunning().rafagaFirstCiclo() == 0){
        getRecurso().getProcesoRunning().finalizarCiclo();
        getRecurso().setEstadoActual(new ConPropietario(getRecurso().getProcesoRunning().getIdP()));
        return getRecurso().liberar();
    } else {
            if(!getColaListos().isEmpty()){
            if(getRecurso().getProcesoRunning().gettIrrupcion() > getColaListos().first().gettIrrupcion()){
                
        this.expropiar();
            } else {
                getRecurso().getProcesoRunning().consumirRafaga();
            }
            } else {
                getRecurso().getProcesoRunning().consumirRafaga();
            }
            
        return null;
    
    }
    
    
    }
    
}
