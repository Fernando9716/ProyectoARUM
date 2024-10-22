/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Componentes.EstructuraCita;
import Componentes.EstructuraInv;
import Componentes.ModeloTablaCita;
import Componentes.ModeloTablaInv;
import control.CitaJpaController;
import control.ServicioJpaController;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import static java.lang.Integer.getInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Cita;
import modelo.Servicio;

/**
 *
 * @author fernando
 */
public class VCita extends javax.swing.JFrame {
private EstructuraCita e = new EstructuraCita();
private EstructuraInv s = new EstructuraInv();
    /**
     * Creates new form Cita
     */
     EntityManagerFactory emf;
    EntityManager em;
    Servicio servicio;
    Cita cita;
    CitaJpaController ec;
    ServicioJpaController control_servicios;
    private String estado ="";
    
    public VCita() {
        initComponents();
        scroll.getViewport().setBackground(Color.decode("#faecdd"));
        calendarioMehod();
       aleSolucionador();
       ocultar();
    }
    public void ocultar(){
        cancelar.setVisible(false);
        guardar.setVisible(false);
    }
    public void conexionLocal (){
        emf = Persistence.createEntityManagerFactory("ArumPU");
        control_servicios = new ServicioJpaController(emf);
        ec = new CitaJpaController(emf);
    }
    
    
    private void aleSolucionador (){
        conexionLocal();
        List<Servicio>listaServicios;
        listaServicios = control_servicios.findServicioEntities();
        
        for (int i = 0; i < listaServicios.size(); i++) {
            tipoServicio.addItem(listaServicios.get(i).getTipoServicio());
        }
    }
    
    public Boolean Validar_Campo(String Hora){
        boolean b;
        System.out.println(Hora);
        char[]a = Hora.toString().toCharArray();
        String[]c = Hora.split(":");
        int hora1 = Integer.parseInt(c[0]);
        int hora2 = Integer.parseInt(c[1]);
        
        System.out.println(c[1]);
        if((a[0]==' ') || (a[1]==' ') || (a[2]==' ')
            || (a[3]==' ') || (a[4] == ' ')
            || (hora1>24) || (hora2>59) ){
            
            b=false;
        } else {
            b= true;
        }
        return b;
    }

    public VCita(GraphicsConfiguration gc) {
        super(gc);
    }

    
    public void AgregarServicios(){
       // boxS.add();
    }
    public void calendarioMehod(){
        Calendar calendarioC = new GregorianCalendar();
        
        
    }
    public void actualizarTabla(){
        this.setVisible(false);
        VCita citaAux = new VCita();
        citaAux.setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ArumPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ArumPU").createEntityManager();
        citaQuery = java.beans.Beans.isDesignTime() ? null : ArumPUEntityManager.createQuery("SELECT c FROM Cita c");
        servicioQuery = java.beans.Beans.isDesignTime() ? null : ArumPUEntityManager.createQuery("SELECT s FROM Servicio s");
        citaQuery8 = java.beans.Beans.isDesignTime() ? null : ArumPUEntityManager.createQuery("SELECT c FROM Cita c");
        citaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : citaQuery8.getResultList();
        citaQuery1 = java.beans.Beans.isDesignTime() ? null : ArumPUEntityManager.createQuery("SELECT c FROM Cita c");
        citaList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : citaQuery1.getResultList();
        citaQuery2 = java.beans.Beans.isDesignTime() ? null : ArumPUEntityManager.createQuery("SELECT c FROM Cita c");
        citaList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : citaQuery2.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipoServicio = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        horaT = new javax.swing.JFormattedTextField();
        calendarioC = new datechooser.beans.DateChooserCombo();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Tipo de servicio:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, -1, 30));
        jPanel2.add(nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 150, 170, -1));

        jLabel4.setText("Fecha de cita");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 300, -1, -1));

        jLabel5.setText("Nombre del cliente: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, -1, -1));

        tipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoServicioActionPerformed(evt);
            }
        });
        jPanel2.add(tipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 200, 170, -1));

        jLabel6.setText("Hora de la cita");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, -1, -1));

        cancelar.setText("Cancelar");
        jPanel2.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 580, 90, 30));

        guardar.setText("Guardar");
        jPanel2.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 580, 90, -1));

        jButton1.setText("Crear cita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 580, -1, -1));

        jButton2.setText("Historial citas");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 580, -1, -1));

        try {
            horaT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        horaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaTActionPerformed(evt);
            }
        });
        jPanel2.add(horaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 260, 170, -1));

        calendarioC.setCurrentView(new datechooser.view.appearance.AppearancesList("Grey",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    calendarioC.setCalendarPreferredSize(new java.awt.Dimension(350, 200));
    calendarioC.setWeekStyle(datechooser.view.WeekDaysStyle.FULL);
    calendarioC.setFieldFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 15));
    calendarioC.setNavigateFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
    calendarioC.setShowOneMonth(true);
    jPanel2.add(calendarioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 260, 30));

    jButton3.setText("Completar");
    jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 630, 120, 30));

    jButton4.setText("Editar");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 580, 90, 30));

    tablaC.setBackground(new java.awt.Color(255, 204, 204));

    org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, citaList2, tablaC);
    org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${folioCita}"));
    columnBinding.setColumnName("Folio Cita");
    columnBinding.setColumnClass(Integer.class);
    columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreCliente}"));
    columnBinding.setColumnName("Nombre Cliente");
    columnBinding.setColumnClass(String.class);
    columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${servicio}"));
    columnBinding.setColumnName("Servicio");
    columnBinding.setColumnClass(String.class);
    columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
    columnBinding.setColumnName("Fecha");
    columnBinding.setColumnClass(java.util.Date.class);
    columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hora}"));
    columnBinding.setColumnName("Hora");
    columnBinding.setColumnClass(String.class);
    bindingGroup.addBinding(jTableBinding);
    jTableBinding.bind();
    tablaC.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            listenerTablaCitas(evt);
        }
    });
    scroll.setViewportView(tablaC);

    jPanel2.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 430));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/19905437_1379224372175931_5828059587373488616_n.jpg"))); // NOI18N
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/degradado.jpg"))); // NOI18N
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 310, 710));

    jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 710));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1271, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    bindingGroup.bind();

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoServicioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Date date = new Date();
        String categoria = (String)tipoServicio.getSelectedItem();
        System.out.println(categoria);
        String horaN = horaT.getText();
       
        cita = new Cita();
        cita.setNombreCliente(nombreCliente.getText());
        cita.setServicio(categoria);
        cita.setFecha(calendarioC.getCurrent().getTime());
        if (Validar_Campo(horaN)==true){
          cita.setHora(horaN);
       }
       else {
           JOptionPane.showMessageDialog(null, "La hora: " + horaT.getText()  
          + "es incorrecta, porfavor introduce una hora en formato de 24 horas");
       }
       conexionLocal();
       ec.create(cita);
       actualizarTabla();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void horaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaTActionPerformed
       
    }//GEN-LAST:event_horaTActionPerformed

    private void listenerTablaCitas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listenerTablaCitas
        int i = tablaC.getSelectedRow();
        nombreCliente.setText(tablaC.getValueAt(i, 1).toString());
        tipoServicio.setSelectedItem(tablaC.getValueAt(i, 2));
        //horaT.setText(tablaC.getValueAt(i, 3).toString());
        calendarioC.setText(tablaC.getValueAt(i, 4).toString());
    }//GEN-LAST:event_listenerTablaCitas

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tablaC.getSelectedRow()>=0){
            guardar.setVisible(true);
            cancelar.setVisible(true);
            estado = "editar";
        }
        else 
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun empleado");
        
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
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ArumPUEntityManager;
    private datechooser.beans.DateChooserCombo calendarioC;
    private javax.swing.JButton cancelar;
    private java.util.List<modelo.Cita> citaList;
    private java.util.List<modelo.Cita> citaList1;
    private java.util.List<modelo.Cita> citaList2;
    private javax.persistence.Query citaQuery;
    private javax.persistence.Query citaQuery1;
    private javax.persistence.Query citaQuery2;
    private javax.persistence.Query citaQuery8;
    private javax.swing.JButton guardar;
    private javax.swing.JFormattedTextField horaT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JScrollPane scroll;
    private javax.persistence.Query servicioQuery;
    private javax.swing.JTable tablaC;
    private javax.swing.JComboBox tipoServicio;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
