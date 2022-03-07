package w1761114;

import gui.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class MainClass {

    public static void main(String[] args) throws IOException, ParseException {
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        menu:
        while (true){
            System.out.println("\nFORMULA 1 CHAMPIONSHIP");
            System.out.println("----------------------\n");
            System.out.println("Press  1 : Add a New Driver");
            System.out.println("Press  2 : Delete an Existing Driver");
            System.out.println("Press  3 : Change Driver Team");
            System.out.println("Press  4 : Display Statistics");
            System.out.println("Press  5 : Display Driver Table");
            System.out.println("Press  6 : Add a Competed Race");
            System.out.println("Press  7 : Save to File");
            System.out.println("Press  8 : Load from File");
            System.out.println("Press  9 : Open GUI");
            System.out.println("Press 10 : Exit the Program");

            switch (formula1ChampionshipManager.inputInt("\nSelect an Option : ")) {
                case 1: // Get Driver Details
                    formula1ChampionshipManager.createDriver();
                    break;
                case 2: // Remove a driver from the driver details arraylist
                    formula1ChampionshipManager.deleteDriver();
                    break;
                case 3: // Change an existing driver's team
                    formula1ChampionshipManager.changeDriverTeam();
                    break;
                case 4: // Display driver statistics
                    formula1ChampionshipManager.driverStats();
                    break;
                case 5: // Display F1 Table according to points
                    formula1ChampionshipManager.displayF1Table();
                    break;
                case 6: // Add a Completed Race to the league
                    formula1ChampionshipManager.addRace();
                    break;
                case 7: // Save Race Details, Driver Details to file
                    formula1ChampionshipManager.saveFile();
                    break;
                case 8: // Load from saved file
                    formula1ChampionshipManager.loadFile();
                    break;
                case 9: //Open the Gui
                    new HomePage();
                    break;
                case 10: // Exit the program
                    System.out.println("\nProgram Exit");
                    break menu;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}




