/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

/**
 *
 * @author fernando
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

public class TimeStamp extends DefaultTableCellRenderer {
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    
    public TimeStamp(){
        super();
    }
    public void SetValue(Object value){
        if (formatter == null){
            formatter = DateFormat.getDateInstance();
        }
        setText((value== null)? "": formatter.format(value));
    }
}
