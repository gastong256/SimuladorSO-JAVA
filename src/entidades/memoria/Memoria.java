/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.memoria;

import entidades.particiones.Particion;
import entidades.particiones.ParticionFija;
import entidades.particiones.ParticionVariable;
import entidades.proceso.Proceso;
import estados.memoria.ConHueco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gasto
 */
public class Memoria {

    //variable que contiene el tamaño de la memoria
    private int tamano;

    //variable que contiene la lista de particiones de la memoria
    private ArrayList<Particion> listaParticiones;

    private Estado estadoActual;

    public Memoria(int... tamanoParticiones) {
        setListaParticiones(new ArrayList<>());
        int total = 0;
        
        if (tamanoParticiones.length == 1) {
            Particion nueva = new ParticionVariable(tamanoParticiones[0]);
            getListaParticiones().add(nueva);
            total += tamanoParticiones[0];
        } else {
            for (int tamano : tamanoParticiones) {
                Particion nuevafija = new ParticionFija(tamano);

                getListaParticiones().add(nuevafija);
                total += tamano;
            }
        }

        setTamano(total);
        setEstadoActual(new ConHueco());
    }

    public ArrayList<Integer> listaParticionesLibre() {
        ArrayList<Integer> listaLibres = new ArrayList<>();
        for (Particion particion : getListaParticiones()) {
            if (particion.isFree()) {
                listaLibres.add(getListaParticiones().indexOf(particion));
            }
        }
        return listaLibres;
    }

    public ArrayList<Integer> listaParticionesOcupada() {
        ArrayList<Integer> listaOcupadas = new ArrayList<>();
        for (Particion particion : getListaParticiones()) {
            if (!particion.isFree()) {
                listaOcupadas.add(getListaParticiones().indexOf(particion));
            }
        }
        return listaOcupadas;
    }
    
    public void cargarProceso(int index, Proceso proceso){
        Particion particionNueva = getListaParticiones().get(index).cargar(proceso);
        if(particionNueva != null){
           getListaParticiones().add(index + 1, particionNueva);
        }
    }

    public int buscarFit(Proceso proceso, ArrayList<Particion> listaLibres){
        int tamano = proceso.getTamano();
        
        int indice = getEstadoActual().buscarFit(tamano, listaLibres);
        if(indice != -1){
        return getListaParticiones().indexOf(listaLibres.get(indice));
        }
        return -1;
    }
   
     //ordena una lista de huecos de menor a mayor
    public void ordenarFitsMenorMayor(ArrayList<Particion> listaFits){
        if(listaFits.size() > 1){
         Collections.sort(listaFits, (Particion p1, Particion p2) -> new Integer(p1.getTamano()).compareTo(p2.getTamano()));
            
          }
    }
    
    //ordena una lista de huecos de mayor a menor
    public void ordenarFitsMayorMenor(ArrayList<Particion> listaFits){
        if(listaFits.size() > 1){
        
            Collections.sort(listaFits, new Comparator<Particion>() {
                @Override
                public int compare(Particion p1, Particion p2) {
                    return new Integer(p2.getTamano()).compareTo(new Integer(p1.getTamano()));
                }
            });
         
        }
    }
    
    public void descargar(Proceso proceso){
        
        for (Integer index : listaParticionesOcupada()) {
            if(proceso.getIdP().equals(getListaParticiones().get(index).getProceso().getIdP())){
                getListaParticiones().get(index).liberar();
            }
        }
    }
    
    //Setter and getter Tamaño
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    //Setter and getter ListaParticiones
    public ArrayList<Particion> getListaParticiones() {
        return listaParticiones;
    }

    public void setListaParticiones(ArrayList<Particion> listaParticiones) {
        this.listaParticiones = listaParticiones;
    }

    
    //setter and getter estadoActual
    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    

}
