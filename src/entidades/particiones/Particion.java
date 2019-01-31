/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.particiones;

import entidades.memoria.Memoria;
import entidades.proceso.Proceso;

/**
 *
 * @author gasto
 */
public abstract class Particion {
    
    
    //variable que almacena el tamaño de la particion
    private int tamano;
    
    //variable que contiene al proceso almacenado en la particion
    private Proceso proceso;
    
    
    
    public Particion(int tamano){
        setTamano(tamano);
        setProceso(null);
    }
    
    //metodo que carga un proceso a la particion
    public abstract Particion cargar(Proceso proceso);
    
    //metodo que devuelve true o false si la particion esta libre
    public boolean isFree(){
        return getProceso() == null;
    }
    
    //metodo que libera la particion
    public void liberar(){
        setProceso(null);
    }
    
    //Setter and getter tamaño
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    //Setter and getter Proceso
    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

   
    
}
