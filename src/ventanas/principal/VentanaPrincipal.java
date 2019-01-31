/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas.principal;

import entidades.administrador.Administrador;
import entidades.memoria.Memoria;
import entidades.particiones.Particion;
import entidades.planificadores.Planificador;
import entidades.planificadores.PlanificadorES;
import entidades.proceso.Proceso;
import entidades.recurso.Recurso;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import ventanas.dibujos.DibujoClock;
import ventanas.dibujos.DibujoProceso;
import ventanas.dibujos.DibujoProcesoLibre;
import ventanas.dibujos.PanelDibujo;
import ventanas.proceso.VentanaConfigurarP;
import ventanas.memoria.VentanaConfigurarM;
import ventanas.recurso.VentanaConfigurar;

/**
 *
 * @author gasto
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public static ArrayList<Proceso> listaDeProcesos = new ArrayList<>();
    public static Memoria memoria = null;
    public static Recurso kernel = null;
    public static Recurso es = null;
    public static Administrador adm = null;
    public static Planificador pln = null;
    public static PlanificadorES plnes = null;
    
    //para dibujar el panel
    public PanelDibujo panel = new PanelDibujo();
    public JScrollPane scroll = new JScrollPane(panel);
    int ultP = 20;
    int ulPes = 20;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
         this.setLayout(null);
          this.setLocationRelativeTo(null);
          tbdPanel.setLayout(null);
           setIconImage(new ImageIcon(getClass().getResource("/ventanas/principal/iconVentanaPral.png")).getImage());
          scroll.setBounds(0, 0, 903,420);
        tbdPanel.add(scroll);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pnlPrincipal = new javax.swing.JPanel();
        tlbarBarraHerramientas = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlProcesos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        pnlMemoria = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTamano = new javax.swing.JLabel();
        lblParticiones = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTamanoParticiones = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblAlgoritmo = new javax.swing.JLabel();
        pnlRecursos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblAlgoritmoK = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listES = new javax.swing.JList<>();
        tbdPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        mnubarBarra = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuEditar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Sadosky v1.0");
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(227, 219, 250));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPrincipal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        tlbarBarraHerramientas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tlbarBarraHerramientas.setFloatable(false);
        tlbarBarraHerramientas.setRollover(true);

        jButton1.setText("Configurar Proceso");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tlbarBarraHerramientas.add(jButton1);

        jButton2.setText("Configurar Memoria");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        tlbarBarraHerramientas.add(jButton2);

        jButton3.setText("Configurar Recursos");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        tlbarBarraHerramientas.add(jButton3);

        jButton4.setText("Play");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        tlbarBarraHerramientas.add(jButton4);

        pnlProcesos.setBackground(new java.awt.Color(243, 243, 243));
        pnlProcesos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Procesos");

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jList2);

        jList3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(jList3);

        javax.swing.GroupLayout pnlProcesosLayout = new javax.swing.GroupLayout(pnlProcesos);
        pnlProcesos.setLayout(pnlProcesosLayout);
        pnlProcesosLayout.setHorizontalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(pnlProcesosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProcesosLayout.setVerticalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pnlMemoria.setBackground(new java.awt.Color(243, 243, 243));
        pnlMemoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Memoria");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Tamaño");

        lblTamano.setBackground(new java.awt.Color(102, 102, 102));
        lblTamano.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTamano.setText("XXX KB");

        lblParticiones.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblParticiones.setText("XXX KB");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Tipo");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("N° Particiones");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTipo.setText("XXX KB");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Particiones");

        lblTamanoParticiones.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTamanoParticiones.setText("XXX KB");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setText("Algoritmo");

        lblAlgoritmo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAlgoritmo.setText("XXX KB");

        javax.swing.GroupLayout pnlMemoriaLayout = new javax.swing.GroupLayout(pnlMemoria);
        pnlMemoria.setLayout(pnlMemoriaLayout);
        pnlMemoriaLayout.setHorizontalGroup(
            pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemoriaLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMemoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMemoriaLayout.createSequentialGroup()
                        .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(49, 49, 49)
                        .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMemoriaLayout.createSequentialGroup()
                        .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTamanoParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMemoriaLayout.setVerticalGroup(
            pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemoriaLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTamano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblParticiones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTamanoParticiones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblAlgoritmo))
                .addGap(0, 48, Short.MAX_VALUE))
        );

        pnlRecursos.setBackground(new java.awt.Color(243, 243, 243));
        pnlRecursos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Kernel");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel12.setText("Algoritmo");

        lblAlgoritmoK.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAlgoritmoK.setText("XXX KB");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("E/S");

        listES.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listES);

        javax.swing.GroupLayout pnlRecursosLayout = new javax.swing.GroupLayout(pnlRecursos);
        pnlRecursos.setLayout(pnlRecursosLayout);
        pnlRecursosLayout.setHorizontalGroup(
            pnlRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecursosLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRecursosLayout.createSequentialGroup()
                .addGroup(pnlRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(pnlRecursosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRecursosLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(36, 36, 36)
                                .addComponent(lblAlgoritmoK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRecursosLayout.setVerticalGroup(
            pnlRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecursosLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblAlgoritmoK))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        tbdPanel.setBackground(new java.awt.Color(227, 219, 250));

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(tlbarBarraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(tlbarBarraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbdPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnubarBarra.setBackground(new java.awt.Color(255, 255, 255));
        mnubarBarra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mnubarBarra.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        mnuArchivo.setText("Archivo");
        mnubarBarra.add(mnuArchivo);

        mnuEditar.setText("Editar");
        mnubarBarra.add(mnuEditar);

        setJMenuBar(mnubarBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaConfigurarP ventanaProceso = new VentanaConfigurarP();
        ventanaProceso.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
VentanaConfigurarM ventanaMemoria = new VentanaConfigurarM();
        ventanaMemoria.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
VentanaConfigurar ventanaRecurso = new VentanaConfigurar();
        ventanaRecurso.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
ArrayList<Proceso> listaOrdenada = new ArrayList<>();
//cargo la lista para ordenar
for (Proceso proceso : listaDeProcesos) {
            listaOrdenada.add(proceso);
        }
Collections.sort(listaOrdenada, new Comparator<Proceso>() {
                @Override
                public int compare(Proceso p1, Proceso p2) {
                    return new Integer(p1.gettArribo()).compareTo(new Integer(p2.gettArribo()));
                }
            });

//agrego los observadores
pln.addObservadorES(plnes);
plnes.addObservadorPlanificador(pln);
adm.addObservadorPlanificador(pln);
        for (Proceso proceso : listaOrdenada) {
            proceso.addObservadorAdministrador(adm);
            proceso.addObservadorES(plnes);
            proceso.addObservadorPlanificador(pln);
            
        }
        
        //hago todo lo demas
        
        ArrayList<Proceso> listaTerminados = new ArrayList<>();
        int terminados = 0;
        int totalProcesos = listaOrdenada.size();
        
        int cont = 0;
        
        while(totalProcesos != terminados){
            
            System.out.println("---------- T=" + cont + " ----------");
            
            for (Proceso aProceso : listaOrdenada) {
                
                if(cont == aProceso.gettArribo()){
                    aProceso.wakeUp();
                }
                
                
            }
            for (Proceso aProceso : listaOrdenada) {
                aProceso.run();
            }
            //tratar finalizados
            for (Proceso aProceso : listaOrdenada) {
                if(aProceso.isOver()){
                    listaTerminados.add(aProceso);
                    terminados += 1;
                }
            }
            if(listaTerminados.size()>0){
                listaOrdenada.remove(listaTerminados.get(0));
                listaTerminados.get(0).run();
                listaTerminados.remove(0);
                      System.out.println("ESTOY AQUIIIIIII");
            }
            
            int iPart = 0;
        for (Particion aPart : memoria.getListaParticiones()) {
            if (aPart.isFree()){
                System.out.println(iPart + " Vacia" + " " + aPart.getTamano() + " KB");
            } else {
             System.out.println(iPart + " " + aPart.getProceso().getIdP() + " " + aPart.getTamano() + " KB");
            }
            iPart +=1;
        }
           
        if(kernel.isFree()){
            System.out.println("Kernel LIBRE");
        } else {
        System.out.println("CPU " + kernel.getProcesoRunning().getIdP() + " Rafagas: " + kernel.getProcesoRunning().firstCiclo().getRafaga());
        }
            
        
        if(es.isFree()){
            System.out.println("E/S LIBRE");
        } else {
        System.out.println("E/S " + es.getProcesoRunning().getIdP() + " Rafagas: " + es.getProcesoRunning().firstCiclo().getRafaga());
        }
        
        //Dibujo kernel
        DibujoProceso dproc = new DibujoProceso();
        dproc.setPosx(ultP);
            dproc.setPosy(80);
        if(kernel.isFree()){
            dproc = new DibujoProcesoLibre();
            dproc.setPosx(ultP);
            dproc.setPosy(80);
            dproc.setColor(Color.LIGHT_GRAY);
            panel.getListaProcesos().add(dproc);
            ultP += 100;
            panel.nuevoProceso();
            scroll.revalidate();
        }else {
            dproc.setPosx(ultP);
            dproc.setPosy(80);
            dproc.setColor(kernel.getProcesoRunning().getColor());
            panel.getListaProcesos().add(dproc);
            ultP += 100;
            panel.nuevoProceso();
            scroll.revalidate();
        }
        //Dibujo entrada salida
        DibujoProceso dproces = new DibujoProceso();
        dproces.setPosx(ulPes);
            dproces.setPosy(170);
        if(es.isFree()){
            dproces = new DibujoProcesoLibre();
            dproces.setPosx(ulPes);
            dproces.setPosy(170);
            dproces.setColor(Color.LIGHT_GRAY);
            panel.getListaEntradaSalida().add(dproces);
            ulPes += 100;
            panel.nuevoProceso();
            scroll.revalidate();
        }else {
            dproces.setPosx(ulPes);
            dproces.setPosy(170);
            dproces.setColor(es.getProcesoRunning().getColor());
            panel.getListaEntradaSalida().add(dproces);
            ulPes += 100;
            panel.nuevoProceso();
            scroll.revalidate();
        }
        
        
        cont +=1;
        }
        DibujoClock clockD = new DibujoClock();
        clockD.setPosx(20);
        clockD.setFin(cont * 100);
        panel.setClock(clockD);
        panel.nuevoClock();
listaOrdenada.clear();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAlgoritmo;
    private javax.swing.JLabel lblAlgoritmoK;
    private javax.swing.JLabel lblParticiones;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JLabel lblTamanoParticiones;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JList<String> listES;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuEditar;
    private javax.swing.JMenuBar mnubarBarra;
    private javax.swing.JPanel pnlMemoria;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProcesos;
    private javax.swing.JPanel pnlRecursos;
    private javax.swing.JTabbedPane tbdPanel;
    private javax.swing.JToolBar tlbarBarraHerramientas;
    // End of variables declaration//GEN-END:variables
}
