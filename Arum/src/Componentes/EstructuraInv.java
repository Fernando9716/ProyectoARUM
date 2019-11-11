/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import control.ProductoJpaController;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Producto;

/**
 *
 * @author fernando
 * 
 */


public class EstructuraInv {
    private Class tipoCampos[] ={int.class,String.class,String.class,float.class,float.class,float.class};
    private String encabezados[]= {"id producto","tipo","descripcion","precio compra","precio venta","ganancia"};
    private int colEditable = 2;
    public Class [] getEstructura(){  return tipoCampos;}
    public String [] getEncabezados(){ return encabezados;}
    public int  getColEditable () { return colEditable;}
    int resta =0;
    Time t ;
    
    public List<Object[]> getRegistros(){
        List<Object[]> regs = new ArrayList <Object[]> ();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArumPU");
        ProductoJpaController accesoP = new ProductoJpaController(emf);
        List <Producto> inventario = accesoP.findProductoEntities();
            
        for (Producto reg:inventario){
            Object campo[] = new Object[tipoCampos.length];
            campo[0]=reg.getIdProducto();
            campo[1]=reg.getTipo();
            campo[2]=reg.getDescripcion();
            campo[3]=reg.getPrecioCompra();
            campo[4]=reg.getPrecioVenta();
            campo[5]= (int)campo[4] - (int) campo[3]; 
            resta += (int)campo[4] - (int) campo[3];
            regs.add(campo);
        }
        
        Object campo [] = new Object [tipoCampos.length];
        campo[2] = "TOTAL:";
        campo[5]= resta;
        regs.add(campo);
       
        return regs;
    }
    
    
}