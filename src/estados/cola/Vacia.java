/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados.cola;

import entidades.cola.Cola;
import entidades.cola.Estado;
import entidades.proceso.Proceso;

/**
 *
 * @author gasto
 */
public class Vacia extends Estado {

    @Override
    public Proceso tryDesencolar(Cola cola) {
    return null; 
    }
    
}
