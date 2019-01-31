/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.planificadores;

import entidades.proceso.Proceso;
import entidades.recurso.Recurso;
import estados.cola.Cargada;
import estados.proceso.Dead;
import estados.proceso.LockedReady;
import estados.proceso.New;
import estados.proceso.Ready;
import estados.recurso.ConPropietario;
import estados.recurso.Libre;

/**
 *
 * @author gasto
 */
public class RoundRobin extends Planificador {

    private int quantum;
    private static int q = 0;

    public RoundRobin(Recurso recurso) {
        super(recurso);
    }

    @Override
    public void organizarCola(Proceso proceso) {

        getColaListos().encolar(proceso);

        proceso.setEstadoActual(new Ready());
        getColaListos().setEstadoActual(new Cargada());

    }

    @Override
    public void runEjecutando() {
        Proceso saliente = ejecutar();
        if (saliente != null) {
            if (saliente.isOver()) {
                System.out.println(saliente.getIdP() + " termino !!");
                saliente.setEstadoActual(new Dead());
                getRecurso().setEstadoActual(new Libre());

            } else {
                getRecurso().setEstadoActual(new Libre());
                saliente.setEstadoActual(new LockedReady());
                notificarBloqueo(saliente);
            }
        }
    }

    @Override
    public Proceso ejecutar() {
        //PREGUNTA SI EL PROCESO TERMINO
        if (getRecurso().getProcesoRunning().rafagaFirstCiclo() == 0) {
            getRecurso().getProcesoRunning().finalizarCiclo();
            getRecurso().setEstadoActual(new ConPropietario(getRecurso().getProcesoRunning().getIdP()));
            q = 0;//SI TERMINA RESETEA EL CONTADOR DE CUOTAS
            return getRecurso().liberar();
        } else {
            //NO TERMINO POR LO TANTO DEBE CONTROLAR SI LE QUEDAN CUOTAS
            if (q == getQuantum()) {
                q = 0;
                this.expropiar();//SI NO LE QUEDAN DEBE EXPROPIAR EL RECURSO
            } else {
                //LE QUEDAN POR LO TANTO CONSUME RAFAGAS DEL PROCESO E INCREMENTA EL CONTADOR DE CUOTA
                getRecurso().getProcesoRunning().consumirRafaga();
                q += 1;
            }
        }
        return null;

    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

}
