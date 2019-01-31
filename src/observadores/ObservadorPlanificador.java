/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observadores;

import entidades.proceso.Proceso;

/**
 *
 * @author gasto
 */
public interface ObservadorPlanificador {
    
    public void encolarNuevoListo(Proceso proceso);
    
    public void runEjecutando();
    
    public void cargarListo();
    
    
}
