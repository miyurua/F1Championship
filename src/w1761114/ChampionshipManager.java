package w1761114;

import java.io.IOException;
import java.text.ParseException;


public interface ChampionshipManager {
    public void createDriver();
    public void deleteDriver();
    public void changeDriverTeam();
    public void driverStats();
    public void displayF1Table();
    public void addRace() throws ParseException;


    void loadFile() throws IOException;
}
