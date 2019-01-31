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
public interface ObservadorES {
    public void encolarBloqueado(Proceso proceso);
    
    public void runBloqueado();
    
    public void cargarBloqueado();
}
