/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.EstructuraInv;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FERNANDO
 */
public class ModeloTablaInv extends AbstractTableModel{
    private List<Object[]>datos;
    private EstructuraInv estructura;
    private String encabezados[];    
    private int colEditable;
    private int colExis;
    private Class tipos[];
    
    public ModeloTablaInv(EstructuraInv est){
        estructura = est;
        datos = est.getRegistros();
        tipos = est.getEstructura();
        encabezados = est.getEncabezados();
        colEditable = est.getColEditable();
    }
    
    public void setDatos(){
        datos = estructura.getRegistros();
    }

    @Override
    public int getRowCount() {
        if(datos != null)
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
    public void setValueAt(Object aValue,int r, int c){
    if(c==colEditable)
        if((Double)datos.get(r)[colEditable]<=(Double)datos.get(r)[1])
            datos.get(r)[colEditable] = aValue;
        else
            datos.get(r)[colEditable] = 0;
    }
    @Override
    public boolean isCellEditable(int r, int c){
        return colEditable==c;
    }   
    }
   

