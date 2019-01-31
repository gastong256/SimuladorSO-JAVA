/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.administrador;

import entidades.cola.Cola;
import entidades.memoria.Memoria;
import entidades.particiones.Particion;
import entidades.proceso.Proceso;
import estados.memoria.ConHueco;
import estados.memoria.SinHueco;
import estados.proceso.Ready;
import java.util.ArrayList;
import observadores.ObservadorAdministrador;
import observadores.ObservadorPlanificador;

/**
 *
 * @author gasto
 */
public abstract class Administrador implements ObservadorAdministrador {
    
    ObservadorPlanificador obsPlanificador;
    
    private Cola colaNuevos;
    private Memoria memoria;
    
    public Administrador(Memoria memoria){
        setColaNuevos(new Cola());
        setMemoria(memoria);
    }
   
    
    
    public abstract ArrayList<Particion> organizarLibres();
    
    @Override
   public void desalojarProceso(Proceso proceso){
       getMemoria().descargar(proceso);
       getMemoria().setEstadoActual(new ConHueco());
       tryCargaNuevo();
   }
    
    
    @Override
    public void encolarNuevo(Proceso proceso) {
    getColaNuevos().encolar(proceso);
    }

    public void addObservadorPlanificador(ObservadorPlanificador obsPln){
        this.obsPlanificador = obsPln;
    }
    public void removeObservadorPlanificador(){
        this.obsPlanificador = null;
    }
    
    
    public void tryCarga(Proceso proceso){
        ArrayList<Particion> listaLibres = organizarLibres();
        int indice = getMemoria().buscarFit(proceso, listaLibres);
        if(indice != -1){
            
            getColaNuevos().first().setEstadoActual(new Ready());
            notificarProcesoCargado();
            getMemoria().cargarProceso(indice, getColaNuevos().desencolar());
            if(getMemoria().listaParticionesLibre().isEmpty()){
                getMemoria().setEstadoActual(new SinHueco());
            }
        }
        
    }
    
    public void notificarProcesoCargado(){
        obsPlanificador.encolarNuevoListo(getColaNuevos().first());
    }
    
    @Override
    public void tryCargaNuevo() {
    if(! getColaNuevos().isEmpty()){
        tryCarga(getColaNuevos().first());
    }
    
    }
    

    
    
//setter and getter cola nuevos
    public Cola getColaNuevos() {
        return colaNuevos;
    }

    public void setColaNuevos(Cola colaNuevos) {
        this.colaNuevos = colaNuevos;
    }

    //setter and getter memoria
    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    
    
    
}
