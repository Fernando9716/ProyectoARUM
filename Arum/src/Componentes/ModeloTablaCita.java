/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;
import Componentes.EstructuraCita;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author fernando
 */
public class ModeloTablaCita extends AbstractTableModel {
    private List <Object []> datos;
    private EstructuraCita estructura;
    private String encabezados[];
    private Class tipos[];
    
    public ModeloTablaCita(EstructuraCita est){
        estructura = est;
        datos = est.getRegistros();
        tipos = est.getEstructura();
        encabezados = est.getEncabezados();
    }
    
    public void setDatos(){
        datos = estructura.getRegistros();
    }
    
    @Override
    public int getRowCount(){
        if(datos !=null)
            return datos.size();
        return 0;
    }
    
    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return datos.get(r)[c];
    }
    @Override
    public String getColumnName(int col){
        return encabezados[col];
    }
    @Override
    public Class getColumnClass(int c){
        return tipos[c];
    }
    
}
