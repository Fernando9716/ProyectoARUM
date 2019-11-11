/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;
import control.CitaJpaController;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cita;

/**
 *
 * @author fernando
 */
public class EstructuraCita {
    private Class tipoCampos[] = {int.class,Time.class,Date.class,String.class,String.class};
    private String encabezados[]={"Folio cita","Hora","Fehca","Nombre Cliente","Servicio"};
    public Class[] getEstructura(){
        return tipoCampos;
    }
    public String [] getEncabezados(){
        return encabezados;
    }
    
    
    public List<Object[]> getRegistros(){
        List<Object []> regs = new ArrayList <Object []> ();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArumPU");
        CitaJpaController accesoP = new CitaJpaController (emf);
        List<Cita> cita = accesoP.findCitaEntities();
        
        for(Cita reg:cita){
            Object campo[] = new Object[tipoCampos.length];
            campo[0] = reg.getFolioCita();
            campo[1] = reg.getHora();
            campo[2] = reg.getFecha();
            campo[3] = reg.getNombreCliente();
            campo[4] = reg.getServicio();
            regs.add(campo);
        }
      
          return regs;
    }
}
