/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proceso;

import java.util.ArrayList;

/**
 *
 * @author gasto
 */
public class Ciclo {

    //contiene la cantidad de rafagas que le corresponden al ciclo
    private int rafaga;
    //contiene el tipo de 
    private int tipoCiclo;
    
    public Ciclo(int tipoCiclo, int rafaga){
        setTipoCiclo(tipoCiclo);
        setRafaga(rafaga);
    }

    //Setter and getter rafagas
    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    //Setter and getter tipoCiclo
    public int getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(int tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

}
