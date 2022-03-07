package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomePage {
    JFrame frame;
    JPanel panel;
    JButton driverTableButton;
    JButton raceTableButton;
    JButton generateRace;

    public HomePage(){

        //referred -> https://www.youtube.com/watch?v=Kmgo00avvEw&t=806s

        //frame
        frame = new JFrame("Formula1 Championship Manger");
        frame.setSize(500, 800);
        frame.setLayout(null);
        ImageIcon frameLogo = new ImageIcon("src/gui/f1.png");
        frame.setIconImage(frameLogo.getImage());//change icon

        //panel
        panel = new JPanel();
        panel.setBounds(0, 0, 500, 800);
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(6,3));

        //Driver Table Button
        driverTableButton = new JButton("Driver Table");
        driverTableButton.setBounds(60, 60, 60, 40);
        driverTableButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                new DriverTable();
            }
        });

        //Race Table Button
        raceTableButton = new JButton("Race Table");
        raceTableButton.setBounds(310, 60, 60, 40);
        raceTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RaceTable();
            }
        });

        //Random Race Same Position Button
        generateRace = new JButton("Random Race - Same Position");
        generateRace.setBounds(60, 120, 60, 40);
        generateRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GenerateRace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Adding to Panel
        panel.setBorder(BorderFactory.createEmptyBorder(200, 80, 50, 100));
        panel.add(driverTableButton);
        panel.add(raceTableButton);
        panel.add(generateRace);
        panel.setLayout(new GridLayout(4, 1));

        //frame Options
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
