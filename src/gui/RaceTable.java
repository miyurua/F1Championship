package gui;

import w1761114.Formula1ChampionshipManager;
import w1761114.Race;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class RaceTable {

    JFrame frame;
    JPanel panel;
    JTable table;
    ArrayList<Race> CHAMPIONSHIP_RACES;

    public RaceTable(){
        CHAMPIONSHIP_RACES = Formula1ChampionshipManager.getRaceDetails();

        frame = new JFrame("Race Table");
        ImageIcon frameLogo = new ImageIcon("src/gui/f1.png");
        frame.setIconImage(frameLogo.getImage());//change icon
        panel = new JPanel();

        String[] raceTableCols = {"Date", "Team", "Team Rank", "Num of Drivers", "First Place"};

        int tableRows = Formula1ChampionshipManager.getRaceDetails().size();
        int tableCols =raceTableCols.length;

        Object[][] raceTableData = new Object[tableRows][tableCols];

        for (int i = 0; i < tableRows; i++){
            for (int j = 0; j < tableCols; j++){
                CHAMPIONSHIP_RACES.get(i).setRaceObjectData();
                raceTableData[i][j] = CHAMPIONSHIP_RACES.get(i).getRaceObjectData()[j];
            }
        }

        table = new JTable(raceTableData, raceTableCols);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(300, 300);
        table.setFillsViewportHeight(true);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
