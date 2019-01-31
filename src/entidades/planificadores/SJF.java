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
import estados.proceso.Exe;
import estados.proceso.New;
import estados.proceso.Ready;
import estados.recurso.ConPropietario;
import estados.recurso.Libre;

/**
 *
 * @author gasto
 */
public class SJF extends Planificador {

    public SJF(Recurso recurso) {
        super(recurso);
    }

    @Override
    public void organizarCola(Proceso proceso) {
    if(getRecurso().hasOwner() && getRecurso().getEstadoActual().getOwner().equals(proceso.getIdP())){
            getColaListos().getListaProcesos().add(0, proceso);
            getRecurso().setEstadoActual(new Libre());
        } else {
     getColaListos().encolar(proceso);
        
        }
    proceso.setEstadoActual(new Ready());
        getColaListos().setEstadoActual(new Cargada());
    }

    @Override
    public Proceso ejecutar() {
    
          
    if(getRecurso().getProcesoRunning().rafagaFirstCiclo() == 0){
        getRecurso().getProcesoRunning().finalizarCiclo();
        getRecurso().setEstadoActual(new ConPropietario(getRecurso().getProcesoRunning().getIdP()));
        return getRecurso().liberar();
    } else {
        getRecurso().getProcesoRunning().consumirRafaga();
    }
        return null;
    }
    
    @Override
    public void cargarListo(){
        
        if(getRecurso().asignar(getColaListos().first())){
            getColaListos().first().setEstadoActual(new Exe());
            getColaListos().desencolar();
            getColaListos().ordenar();
            if(getColaListos().getListaProcesos().isEmpty()){
                getColaListos().setEstadoActual(new Vacia());
            }
        }
    }
    
    
    }
    

