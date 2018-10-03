/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex005;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author franz
 */
public class VelocityTableModel extends AbstractTableModel{

    private static String[] COLNAMES = {"Datum","Uhrzeit","Kennzeichen","Gemessen", "Erlaubt", "Übertretung"};
    private ArrayList<Measurement> measures = new ArrayList<>();
    private DateTimeFormatter dtfDatum = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter dtfUhrzeit = DateTimeFormatter.ofPattern("hh:mm");
    
    @Override
    public int getRowCount() {
        return measures.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Measurement m = measures.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return m.getLdt().format(dtfDatum);
            case 1: return m.getLdt().format(dtfUhrzeit);
            case 2: return m.getKennzeichen();
            case 3: return m.getGemessen();
            case 4: return m.getErlaubt();
            case 5: return m.getGemessen()-m.getErlaubt();
            
            default: return "???";
        }
    }
    
}
