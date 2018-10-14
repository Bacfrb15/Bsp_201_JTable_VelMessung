/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex005;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            case 0: return m.getDatum().format(dtfDatum);
            case 1: return m.getUhrzeit().format(dtfUhrzeit);
            case 2: return m.getKennzeichen();
            case 3: return m.getGemessen();
            case 4: return m.getErlaubt();
            case 5: return m.getGemessen()-m.getErlaubt();
            
            default: return "???";
        }
    }

    public void add(Measurement m) {
        measures.add(m);
        fireTableRowsInserted(measures.size()-1, measures.size()-1);
    }
    
    public void removeElements(int... selectedRows) {
        for (int i = selectedRows.length-1 ;i >= 0 ;i--) {
            measures.remove(selectedRows[i]);
            fireTableRowsDeleted(selectedRows[i], selectedRows[i]);
        }
    }
    
    public double avgÜbertretung() {
        double x = 0;
        for (Measurement m : measures) {
            x += m.getUebertretung();
        }
        return x / measures.size();
    }
    
    public void load(File f) throws Exception {
        measures.clear();
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f));
        Object m = null;
        while ((m = ois.readObject()) != null) {
            add((Measurement) m);
        }
    }

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(f));
        for (Measurement m : measures) {
            oos.writeObject(m);
        }
        oos.flush();
    }
}
