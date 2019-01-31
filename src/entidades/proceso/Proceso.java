/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proceso;




import estados.proceso.*;
import java.awt.Color;
import java.util.ArrayList;
import observadores.ObservadorAdministrador;
import observadores.ObservadorES;
import observadores.ObservadorPlanificador;

/**
 *
 * @author gasto
 */
public class Proceso {
    
    //obs admmemoria
    private ObservadorAdministrador obsAdministrador;
    
    //obs planproc
    private ObservadorPlanificador obsPlanificador;
    
    //obs plnes
    private ObservadorES obsES;
    
    //contiene el id del proceso
    private String idP;
    
    //contiene el tiempo de arribo
    private int tArribo;
    
    private ArrayList<Ciclo> listaCiclos;
    
    //contiene el tamaño que ocupa el proceso
    private int tamano;
    
   //contiene el estado actual del proceso
    private Estado estadoActual;
    
    //variable de clase para asignar un nuevo Id
    private static int ultIdP = 0;
    
    private Color color;
    private static int r,g,b;
    
    private int tIrrupcion;
    
    private int tiempoEspera;
    
    private int tiempoSobrecarga;
    
    private int tiempoLatencia;
    
    private int tiempoRetorno;
    //CONSTRUCTOR, recibe de parametros el tArribo y la rafaga
    public Proceso(int tArribo, int tamano) {
        ultIdP += 1;//Obtengo un nuevo Id
        setIdP("P" + ultIdP);//Asigno el nuevo Id

        //asigno el tarribo
        settArribo(tArribo);
        
        //asigno el tamaño
        setTamano(tamano);
        
        //inicializo la lista de ciclos
        setListaCiclos(new ArrayList<>());
        
        setEstadoActual(new Sleep());
        
        setR((int)(Math.random()*255));
        setG((int)(Math.random()*255));
        setB((int)(Math.random()*255));
        color = new Color(getR(),getG(),getB());
                      
        }
    
    //metodo que se ejecuta segun el estado
    public void run(){
        getEstadoActual().run(this);
    }
    
    //agregar obsAdm
    public void addObservadorAdministrador(ObservadorAdministrador obsAdm){
        this.obsAdministrador = obsAdm;
    }
    
    //retirar obsAdm
    public void removeObservadorAdministrador(){
    this.obsAdministrador = null;
}
    
    //agregar obsAdm
    public void addObservadorPlanificador(ObservadorPlanificador obsPln){
        this.obsPlanificador = obsPln;
    }
    
    //retirar obsAdm
    public void removeObservadorPlanificador(){
    this.obsPlanificador = null;
}
   //add obses
    public void addObservadorES(ObservadorES obsES){
        this.obsES = obsES;
    }
    public void removeObservadorES(){
        this.obsES = null;
    }
    
    //metodo que despierta al proceso
    public void wakeUp(){
        setEstadoActual(new New());
        notificarDespierto();
    }
    
    //notificacion despierto
    public void notificarDespierto(){
        obsAdministrador.encolarNuevo(this);
    }
    
    //notificar nuevo
    public void notificarNuevo(){
        obsAdministrador.tryCargaNuevo();
    }
        
    //metodo que agrega un ciclo a la lista de ciclos
public void addCiclo(int tipo, int rafaga){
    getListaCiclos().add(new Ciclo(tipo, rafaga));
    if(tipo == 0){
        tIrrupcion += rafaga;
    }
}
    
//metodo que devuelve el primer ciclo
public Ciclo firstCiclo(){
    return getListaCiclos().get(0);
}

//metodo que devuelve la rafaga del primer ciclo
public int rafagaFirstCiclo(){
    return firstCiclo().getRafaga();
}

//metodo que devuelve true o false si el ciclo termino
public boolean isCicloOver(){
    return rafagaFirstCiclo() == 0;
}

//metodo que remueve el primer ciclo de la lista de ciclos
public void finalizarCiclo(){
    getListaCiclos().remove(firstCiclo());
}




//metodo que devuelve true o false si el proceso finalizo
public boolean isOver(){
    return getListaCiclos().isEmpty();
}


/*   quitar           */
//metodo que descuenta una rafaga al primer ciclo
public void consumirRafaga(){
    Ciclo descontado = firstCiclo();
    descontado.setRafaga(descontado.getRafaga() - 1);
}

    //Setter and getter idP
    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }
    
    //Setter and getter tArribo
    public int gettArribo() {
        return tArribo;
    }

    public void settArribo(int tArribo) {
        this.tArribo = tArribo;
    }
    
    //Setter and getter tamano
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    //Setter and getter listaCiclos
    public ArrayList<Ciclo> getListaCiclos() {
        return listaCiclos;
    }

    public void setListaCiclos(ArrayList<Ciclo> listaCiclos) {
        this.listaCiclos = listaCiclos;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public ObservadorAdministrador getObsAdministrador() {
        return obsAdministrador;
    }

    public ObservadorPlanificador getObsPlanificador() {
        return obsPlanificador;
    }

    public ObservadorES getObsES() {
        return obsES;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static int getR() {
        return r;
    }

    public static void setR(int r) {
        Proceso.r = r;
    }

    public static int getG() {
        return g;
    }

    public static void setG(int g) {
        Proceso.g = g;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        Proceso.b = b;
    }

    public int gettIrrupcion() {
        return tIrrupcion;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public int getTiempoSobrecarga() {
        return tiempoSobrecarga;
    }

    public int getTiempoLatencia() {
        return tiempoLatencia;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }
    
    
    

    
    
    
    
    
    
    
    
    
}
