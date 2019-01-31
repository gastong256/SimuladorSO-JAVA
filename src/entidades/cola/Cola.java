/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.cola;

import entidades.proceso.Proceso;
import estados.cola.Cargada;
import estados.cola.Vacia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gasto
 */
public class Cola {
    
     //lista que almacena los procesos
    ArrayList<Proceso> listaProcesos;
    Estado estadoActual;
    
    public Cola(){
        setListaProcesos(new ArrayList<>());
        setEstadoActual(new Vacia());
    }
    
    //metodo que agregar un elemento a la cola
    public void encolar(Proceso proceso) {   
        getListaProcesos().add(proceso);
        setEstadoActual(new Cargada());
        
    }
    
    //metodo que desencola un proceso
    public Proceso desencolar(){
        return getEstadoActual().tryDesencolar(this);
    }
    
    //metodo que ordena la cola por el tiempo de kernel
    public void ordenar() {
        if (getListaProcesos().size() > 1) {
            Collections.sort(getListaProcesos(), new Comparator<Proceso>() {
                @Override
                public int compare(Proceso p1, Proceso p2) {
                    return new Integer(p1.gettIrrupcion()).compareTo(new Integer(p2.gettIrrupcion()));
                }
            });
        }
    }
    
    //metodo que devuelve el primer elemento de la cola
    public Proceso first(){
        return getListaProcesos().get(0);
    }
    
    //metodo que devuelve true o false si la cola esta vacia
    public boolean isEmpty(){
        return getListaProcesos().isEmpty();
    }
    
    //Setter and getter lista de procesos
    public ArrayList<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    
}
