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
import estados.proceso.LockedExe;
import estados.proceso.LockedReady;
import estados.proceso.Ready;
import estados.recurso.Libre;
import observadores.ObservadorES;
import observadores.ObservadorPlanificador;

/**
 *
 * @author gasto
 */
public class PlanificadorES extends Planificador implements ObservadorES {

    ObservadorPlanificador obsPlanificador;
    
    public PlanificadorES(Recurso recurso) {
        super(recurso);
    }

    @Override
    public void organizarCola(Proceso proceso) {
    getColaListos().encolar(proceso);
        getColaListos().setEstadoActual(new Cargada());    
        
    }

    @Override
    public Proceso ejecutar() {
    if(getRecurso().getProcesoRunning().rafagaFirstCiclo() == 0){
        getRecurso().getProcesoRunning().finalizarCiclo();
        getRecurso().setEstadoActual(new Libre());
        return getRecurso().liberar();
    } else {
        getRecurso().getProcesoRunning().consumirRafaga();
    }
        return null;   
    }

    @Override
    public void encolarBloqueado(Proceso proceso) {
     organizarCola(proceso);
        cargarBloqueado();
    }

    @Override
    public void runBloqueado() {
    Proceso saliente = ejecutar();
        if(saliente != null){
           
              
               saliente.setEstadoActual(new Ready());
               notificarFinEs(saliente);
           } 
        }  
    
    public void notificarFinEs(Proceso proceso){
        getObsPlanificador().encolarNuevoListo(proceso);
    }

    @Override
    public void cargarBloqueado() {
    if(getRecurso().asignar(getColaListos().first())){
        getColaListos().first().setEstadoActual(new LockedExe());
            getColaListos().desencolar();
            if(getColaListos().getListaProcesos().isEmpty()){
                getColaListos().setEstadoActual(new Vacia());
            }
        }  
    }
    
    public void addObservadorPlanificador(ObservadorPlanificador obsPln){
        this.obsPlanificador = obsPln;
    }

    public void removeObservadorPlanificador(){
        this.obsPlanificador = null;
    }

    public ObservadorPlanificador getObsPlanificador() {
        return obsPlanificador;
    }
    
    
}
