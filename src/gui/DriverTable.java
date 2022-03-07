package gui;

import w1761114.Formula1ChampionshipManager;
import w1761114.Formula1Driver;

import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;


public class DriverTable {

    JFrame frame;
    JPanel panel;
    JTable driverTable;
    Object[][] driverTableData;
    ArrayList<Formula1Driver> FORMULA_1_DRIVERS;


    public DriverTable() {
        FORMULA_1_DRIVERS = Formula1ChampionshipManager.getDriverDetails();

        frame = new JFrame("Driver Table");
        frame.setSize(1000, 500);
        ImageIcon frameLogo = new ImageIcon("src/gui/f1.png");
        frame.setIconImage(frameLogo.getImage());//change icon
        panel = new JPanel();

        String[] driverTableCols = {"Name", "Team", "Points", "First Positions", "Second Positions", "Third Positions"};
        int tableRows = Formula1ChampionshipManager.getDriverDetails().size();
        int tableCols = 6;
        Object[][] driverTableData = new Object[tableRows][tableCols];

        for (int i = 0; i < tableRows; i++){
            for (int j = 0; j < tableCols; j++){
                FORMULA_1_DRIVERS.get((i)).setDriverObjectData();
                driverTableData[i][j] = FORMULA_1_DRIVERS.get(i).getDriverObjectData()[j];
            }
        }

        driverTable = new JTable(driverTableData, driverTableCols);
        driverTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(driverTable);
        scrollPane.setSize(1000, 500);
        driverTable.setFillsViewportHeight(true);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}
