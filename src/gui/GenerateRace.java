package gui;

import w1761114.Formula1ChampionshipManager;
import w1761114.Formula1Driver;
import w1761114.Race;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GenerateRace {

    ArrayList<Formula1Driver> FORMULA_1_DRIVERS;
    ArrayList<Race> CHAMPIONSHIP_RACES;
    Formula1Driver[] driverPosition;
    int[] fixedRaceWinPoints;
    Race CHAMPIONSHIP_RACE;

    public GenerateRace() throws IOException {
        CHAMPIONSHIP_RACES = Formula1ChampionshipManager.getRaceDetails();
        FORMULA_1_DRIVERS = Formula1ChampionshipManager.getDriverDetails();
        fixedRaceWinPoints = Formula1ChampionshipManager.fixedRaceWinPoints;
        generateRace();
    }

    void generateRace() throws IOException , NullPointerException{
        CHAMPIONSHIP_RACE = new Race();
        driverPosition = new Formula1Driver[FORMULA_1_DRIVERS.size()];

        CHAMPIONSHIP_RACE.setRaceNum(CHAMPIONSHIP_RACES.size() + 1);
        CHAMPIONSHIP_RACE.setNumOfDrivers(driverPosition.length);

        Collections.shuffle(FORMULA_1_DRIVERS);

        JFrame frame = new JFrame("Add Race");
        JPanel panel = new JPanel();

        CHAMPIONSHIP_RACE.getDriverPosition(driverPosition);
        CHAMPIONSHIP_RACE.setRaceObjectData();
        CHAMPIONSHIP_RACES.add(CHAMPIONSHIP_RACE);

        JLabel titleLabel = new JLabel("Race Number: " + CHAMPIONSHIP_RACE.getRaceNum() + "on " + CHAMPIONSHIP_RACE.getDate().toString());

        panel.setLayout(new BorderLayout());
        panel.add(titleLabel, BorderLayout.PAGE_START);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        Formula1ChampionshipManager.saveFile();


    }


    private void randomRace() {

        for (int i = 0; i < CHAMPIONSHIP_RACE.getNumOfDrivers(); i++) {
            driverPosition[i] = FORMULA_1_DRIVERS.get(i);
            Formula1Driver driver1 = new Formula1Driver();
            Formula1Driver driver = driverPosition[i];
            driver.addNumOfRaces();

            if (i < 10) {
                driver.setSeasonPoints(driver.getSeasonPoints() + fixedRaceWinPoints[i]);
                driver.addNumOfRaces();
            }if (i == 0) {
                CHAMPIONSHIP_RACE.setWinTeam(driver.getDriverTeam());
                driver1.addFirstPositionCount();
            }if (i == 1) {
                driver1.addSecondPositionsCount();
            }if (i == 2){
                driver1.addThirdPositionsCount();
            }
        }
    }

}
