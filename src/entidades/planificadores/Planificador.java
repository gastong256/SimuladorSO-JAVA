/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.planificadores;

import entidades.cola.Cola;
import entidades.proceso.Proceso;
import entidades.recurso.Recurso;
import estados.cola.Vacia;
import estados.proceso.Dead;
import estados.proceso.Exe;
import estados.proceso.LockedReady;
import estados.recurso.ConPropietario;
import estados.recurso.Libre;
import observadores.ObservadorES;
import observadores.ObservadorPlanificador;

/**
 *
 * @author gasto
 */
public abstract class Planificador implements ObservadorPlanificador {
    
    private Cola colaListos;
    private Recurso recurso;
    ObservadorES obsES;
    
    
    public Planificador(Recurso recurso){
        setColaListos(new Cola());
        setRecurso(recurso);
    }

    public abstract void organizarCola(Proceso proceso);
    public abstract Proceso ejecutar();
    
    @Override
    public void encolarNuevoListo(Proceso proceso){
        organizarCola(proceso);
    }
    
    @Override
    public void runEjecutando(){
        Proceso saliente = ejecutar();
        if(saliente != null){
           if(saliente.isOver()){
               System.out.print(saliente.getIdP() + " termino !!");
               saliente.setEstadoActual(new Dead());
               getRecurso().setEstadoActual(new Libre());
              
           }  else {
               getRecurso().setEstadoActual(new ConPropietario(saliente.getIdP()));
               saliente.setEstadoActual(new LockedReady());
               notificarBloqueo(saliente);
           } 
        }
    }
    
    public void notificarBloqueo(Proceso proceso){
        obsES.encolarBloqueado(proceso);
    }
    
    @Override
    public void cargarListo(){
        if(getRecurso().asignar(getColaListos().first())){
            getColaListos().first().setEstadoActual(new Exe());
            getColaListos().desencolar();
            if(getColaListos().getListaProcesos().isEmpty()){
                getColaListos().setEstadoActual(new Vacia());
            }
        }
    }
    
    public void expropiar(){
        Proceso expropiado = getRecurso().liberar();
        this.encolarNuevoListo(expropiado);
        getRecurso().setEstadoActual(new Libre());
    }
    
    public void addObservadorES(ObservadorES obsES){
        this.obsES = obsES;
    }
    
    public void removeObservadorES(){
        this.obsES = null;
    }
    
    //-----Setter and getter
    public Cola getColaListos() {
        return colaListos;
    }

    public void setColaListos(Cola colaListos) {
        this.colaListos = colaListos;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    
    
    
}
