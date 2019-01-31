/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import entidades.administrador.Administrador;
import entidades.administrador.BestFit;
import entidades.administrador.FirstFit;
import entidades.administrador.WorstFit;
import entidades.memoria.Memoria;
import entidades.particiones.Particion;
import entidades.planificadores.FCFS;
import entidades.planificadores.Planificador;
import entidades.planificadores.PlanificadorES;
import entidades.planificadores.RoundRobin;
import entidades.planificadores.SJF;
import entidades.planificadores.SRTF;
import entidades.proceso.Ciclo;
import entidades.proceso.Proceso;
import entidades.recurso.Recurso;
import java.util.ArrayList;

/**
 *
 * @author gasto
 */
public class Prueba {
    
    
    public static void main(String[] args) {
        
        //def de Memoria
        Memoria memoria = new Memoria(30,35,25);
        
        //def administrador de mem
        Administrador admFirstFit = new FirstFit(memoria);
        
        //def de recurso
        Recurso kernel = new Recurso();
        Recurso es = new Recurso();
        
        //def de planificador
        //Planificador plnKernel = new SRTF(kernel);
        
        // Planificador plnKernel = new SJF(kernel);
         //Planificador plnKernel = new FCFS(kernel);
        RoundRobin plnKernel = new RoundRobin(kernel);
        //plnKernel.setQuantum(4);
        
        //int quant = 0;
        //int cuant = plnKernel.getQuantum();
        
        
        plnKernel.setQuantum(3);
        PlanificadorES plnES = new PlanificadorES(es);
        plnKernel.addObservadorES(plnES);
        plnES.addObservadorPlanificador(plnKernel);
        
        
        
        //registro obs para el adm de memoria
        admFirstFit.addObservadorPlanificador(plnKernel);
        
        
        Proceso a,b,c,d;
        a = new Proceso(1,25);
        b = new Proceso(2,10);
        c = new Proceso(2,25);
        d = new Proceso(3,25);
        
        //agrego el observer a cada proceso
        a.addObservadorAdministrador(admFirstFit);
        a.addObservadorPlanificador(plnKernel);
        a.addObservadorES(plnES);
        a.addCiclo(0, 5);
        a.addCiclo(1, 2);
        a.addCiclo(0, 5);
        
        b.addObservadorAdministrador(admFirstFit);
        b.addObservadorPlanificador(plnKernel);
        b.addObservadorES(plnES);
        b.addCiclo(0, 4);
        b.addCiclo(1, 2);
        b.addCiclo(0, 5);
        
        c.addObservadorAdministrador(admFirstFit);
        c.addObservadorPlanificador(plnKernel);
        c.addObservadorES(plnES);
        c.addCiclo(0, 3);
        c.addCiclo(1, 2);
        c.addCiclo(0, 2);
        
        d.addObservadorAdministrador(admFirstFit);
        d.addObservadorPlanificador(plnKernel);
        d.addObservadorES(plnES);
        d.addCiclo(0, 1);
        d.addCiclo(1, 2);
        d.addCiclo(0, 0);
        
        ArrayList<Proceso> listaProcesos = new ArrayList<>();
        listaProcesos.add(a);
        listaProcesos.add(b);
        listaProcesos.add(c);
        listaProcesos.add(d);
        
        ArrayList<Proceso> listaTerminados = new ArrayList<>();
        int terminados = 0;
        int totalProcesos = listaProcesos.size();
        
        int cont = 0;
        
        System.out.println("ESCENARIO: PROCESOS");
        System.out.println("");
        System.out.println("PID   TArr   Tam(KB)          Rafagas");
        System.out.println("");
        for (Proceso proceso : listaProcesos) {
            System.out.print(proceso.getIdP() +"    "+  proceso.gettArribo()+"       " + proceso.getTamano()+"              ");
            for (Ciclo aciclo : proceso.getListaCiclos()) {
                System.out.print(aciclo.getRafaga() + " ");
            }
            System.out.println("");
        }
               System.out.println("");

        while(totalProcesos != terminados){
            System.out.println("----------------------------------------------------------");
            System.out.println("************************* T = " + cont + " *************************");
            System.out.println("----------------------------------------------------------");
            
            for (Proceso aProceso : listaProcesos) {
                
                if(cont == aProceso.gettArribo()){
                    aProceso.wakeUp();
                }
                
                
            }
            for (Proceso aProceso : listaProcesos) {
                aProceso.run();
            }
            
            
            //tratar finalizados
            for (Proceso aProceso : listaProcesos) {
                if(aProceso.isOver()){
                    listaTerminados.add(aProceso);
                    terminados += 1;
                }
            }
            if(listaTerminados.size()>0){
                listaProcesos.remove(listaTerminados.get(0));
                listaTerminados.get(0).run();
                listaTerminados.remove(0);
                      
            }
            
            //imprimo kernel y cola listos
            System.out.println("");
            System.out.println("Planificacion CPU");
            System.out.println("**************************");
                if(plnKernel.getColaListos().isEmpty()){
                    System.out.println("COLA LISTOS:    Vacia");
                } else {
                    System.out.print("COLA LISTOS:    ");
                    for(Proceso proceso: plnKernel.getColaListos().getListaProcesos()){
                        System.out.print(proceso.getIdP() + "  ");
                    }
                }
                
            
   
        if(kernel.isFree()){
            System.out.println("CPU:    LIBRE");
        } else {
        System.out.println("CPU:    " + kernel.getProcesoRunning().getIdP() + " Rafagas restantes: " + kernel.getProcesoRunning().firstCiclo().getRafaga());
        }
            System.out.println("**************************");
            System.out.println("");
            System.out.println("Planificacion E/S");
            System.out.println("**************************");
        if(plnES.getColaListos().isEmpty()){
                    System.out.println("COLA E/S:    Vacia");
                } else {
                    System.out.println("");
                    for(Proceso proceso: plnES.getColaListos().getListaProcesos()){
                        System.out.print(proceso.getIdP() + "  ");
                    }
                }
                
        
        if(es.isFree()){
            System.out.println("E/S:    LIBRE");
        } else {
        System.out.println("E/S:    " + es.getProcesoRunning().getIdP() + " Rafagas restantes: " + es.getProcesoRunning().firstCiclo().getRafaga());
        }
            System.out.println("**************************");
        
        System.out.println("");
        
        //Salida memoria
            System.out.println("Memoria");
        int iPart = 0;
        for (Particion aPart : memoria.getListaParticiones()) {
            System.out.println("-------------------");
            if (aPart.isFree()){
                System.out.println("|    Vacia        |" + " Part/"+ iPart + "/ "  + aPart.getTamano() + " KB");
            } else {
             System.out.println("|    " + aPart.getProceso().getIdP() +"           |"+  " Part/"+ iPart + "/ "  + aPart.getTamano() + " KB");
            
            }
            System.out.println("-------------------");
            iPart +=1;
        }
            System.out.println("");
        cont +=1;
        }
        
        
        
    }
    
}
