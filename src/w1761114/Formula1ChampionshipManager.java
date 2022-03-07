package w1761114;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {
    //ArrayList that holds the formula1 drivers
    protected static ArrayList<Formula1Driver> FORMULA_1_DRIVERS = new ArrayList<>();
    //ArrayList that holds the Race Details
    protected static ArrayList<Race> CHAMPIONSHIP_RACES = new ArrayList<>();
    //Race Values.
    public static int[] fixedRaceWinPoints = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    public int inputInt(String msg){
        Scanner sc = new Scanner(System.in);
        String input;
        while (true){
            System.out.print(msg);
            input = sc.nextLine().toLowerCase(Locale.ROOT);
            try {
                Integer.parseInt(input);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error - Enter an Integer Value"); // If someone entered characters other than integers
            }
        }
        return Integer.parseInt(input);
    }

    //Method to Get String Inputs
    public String inputStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Error - This Field Cannot be Empty");    // If entered without entering anything
            }
            else {
                break;
            }
        }
        return input;
    }

    //Method to check if entered name is in drivers arraylist
    public int nameCheck(String name) {
        int index = -1;
        int count = 0;
        for (Formula1Driver driver : FORMULA_1_DRIVERS) {
            if (driver.getDriverName().equals(name)) {
                index = count;
            }
            count++;
        }
        return index;
    }

    //Name & Team Checker
    //reference --> https://www.tutorialspoint.com/how-to-search-for-a-string-in-an-arraylist-in-java
    public int check(String name, String team) {
        int index = -1;
        int count = 0;
        for (Formula1Driver item : FORMULA_1_DRIVERS) {

            if (item.getDriverName().equals(name) && (item.getDriverTeam().equals(team))) {
                index = count;
            }
            count++;
        }
        return index;
    }

    //method to check if the race exists in the race arraylist
    public int raceCheck(String name){
        int index = -1;
        int count = 0;
        for (Race race : CHAMPIONSHIP_RACES){
            if (race.getTeamName().equals(name)){
                index = count;
            }
            count++;
        }
        return index;
    }

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to add a driver to the championship
     */
    @Override
    public void createDriver(){
        System.out.println("\nCreate Driver");

        String driverName = inputStr("\nEnter the Driver's Name: ");
        String driverTeam = inputStr("\nEnter Driver's Team: ");
        if (check(driverName, driverTeam) == -1) {
            int driverAge = inputInt("\nEnter Driver's Age: ");
            String driverLocation = inputStr("\nEnter Driver's Location: ");
            String driverNationality = inputStr("\nEnter Driver's Nationality: ");
            Formula1Driver newFormula1Driver = new Formula1Driver(driverName, driverAge, driverLocation, driverNationality, driverTeam);
            FORMULA_1_DRIVERS.add(newFormula1Driver);
        }
        else {
            System.out.println("\nDriver is Already in the Championship");
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to remove a driver from the championship
     */
    @Override
    public void deleteDriver() {
        System.out.println("\nDelete Driver");

        String driverName = inputStr("\nEnter the Driver's Name: ");
        String driverTeam = inputStr("\nEnter the Driver's Team: ");
        if (check(driverName, driverTeam) != -1) {
            FORMULA_1_DRIVERS.remove(check(driverName,driverTeam));
        }
        else {
            System.out.println("Driver Does Not Exist");
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * method to change a driver from an existing team
     */
    @Override
    public void changeDriverTeam() {
        System.out.println("\nChange Driver's Team");

        String driverName = inputStr("\nEnter Driver's Name: ");
        String driverTeam = inputStr("\nEnter Driver's Current Team: ");
        if (check(driverName, driverTeam) != -1) {
            FORMULA_1_DRIVERS.get(check(driverName, driverTeam)).setDriverTeam(inputStr("\nEnter Driver's New Team: "));
        }
        else {
            System.out.println("Driver Does Not Exist");
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * method to see individual driver stats
     */
    @Override
    public void driverStats() {
        System.out.println("Driver Stats");

        String driverName = inputStr("\nEnter the Driver's Name: ");
        if (nameCheck(driverName) != -1) {
            FORMULA_1_DRIVERS.get(nameCheck(driverName)).displayStats();
        }
        else {
            System.out.println("Driver Does Not Exist");
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to Display Driver F1 Table
     */
    @Override
    public void displayF1Table() {
        System.out.println("\nFormula1 Driver Table\n");

        if (!FORMULA_1_DRIVERS.isEmpty()){
            // Sort According to Points
            FORMULA_1_DRIVERS.sort(Comparator.comparingInt(Formula1Driver::getSeasonPoints));
            Collections.reverse(FORMULA_1_DRIVERS);

            //Table Headers Using String Formatting
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Driver's Name", "Team Name", "Season Points", "1st Positions", "2nd Positions", "3rd Positions");
            System.out.println("");

            //table data
            for(Formula1Driver f1Driver : FORMULA_1_DRIVERS){
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", f1Driver.getDriverName(), f1Driver.getDriverTeam(),
                        f1Driver.getSeasonPoints(), f1Driver.firstPositions, f1Driver.secondPositions, f1Driver.thirdPositions);
                System.out.println();
            }
            System.out.println("\n");
        }
        else {
            System.out.println("No Drivers in the League");
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to add a completed race
     * @throws ParseException
     */
    @Override
    public void addRace() throws ParseException {

        Race race = new Race();

        String raceDate = inputStr("Enter the Date: ");
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(raceDate);

        int driverCount = inputInt("Enter the Number of Drivers: ");
        //race.setNumOfDrivers(driverCount);

        if (driverCount < 10) {
            System.out.println("\nMinimum of 10 Drivers need to be Present");
        }else{
            for (int i = 0; i < driverCount; i++){
                String teamName = inputStr("\nEnter Team Name : ");
                int racePos = inputInt("Enter the Race Position: ");

                if (raceCheck(teamName) == -1){
                    Race newRace = new Race(date, teamName, racePos, driverCount);
                    CHAMPIONSHIP_RACES.add(newRace);
                }else{
                    System.out.println("Could not Add Race");
                }
            }

            //Sorting the Championship Races According to Race Rank
            Collections.sort(CHAMPIONSHIP_RACES, new Comparator<Race>() {
                public int compare(Race o1, Race o2) {
                    return Integer.valueOf(o1.raceRank).compareTo(o2.raceRank);
                }
            });

            System.out.println("Race Recorded");

            for(int count = 0; count < driverCount; count++)
                for (Formula1Driver f1ArraylistObj: FORMULA_1_DRIVERS){
                    if (CHAMPIONSHIP_RACES.get(count).getTeamName().equals(f1ArraylistObj.getDriverTeam())) {
                        f1ArraylistObj.setSeasonPoints(fixedRaceWinPoints[count]);
                        if (count == 0) {
                            f1ArraylistObj.addFirstPositionCount();
                        }
                        if (count == 1) {
                            f1ArraylistObj.addSecondPositionsCount();
                        }
                        if (count == 2) {
                            f1ArraylistObj.addThirdPositionsCount();
                        }
                        f1ArraylistObj.addNumOfRaces();
                    }
                }
            System.out.println(CHAMPIONSHIP_RACES);
            CHAMPIONSHIP_RACES.clear();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to save data into file
     */
    public static void saveFile() throws IOException{
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/w1761114/DriverDetails.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            FileOutputStream fileOutputStream1 = new FileOutputStream("src/w1761114/RaceDetails.txt");
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream1);

            for (Formula1Driver driver : FORMULA_1_DRIVERS) {
                objectOutputStream.writeObject(driver);
            }
            for (Race race: CHAMPIONSHIP_RACES){
                objectOutputStream2.writeObject(race);
            }
            objectOutputStream.close();
            objectOutputStream2.close();

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Method to load from file
     * @throws IOException
     */
    @Override
    public void loadFile() throws IOException {
        try {//Load Driver Details From saved File
            FileInputStream fileInputStream = new FileInputStream("src/w1761114/DriverDetails.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            FileInputStream fileInputStream2 = new FileInputStream("src/w1761114/RaceDetails.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);

            for(;;){
                try{
                    FORMULA_1_DRIVERS.add((Formula1Driver) objectInputStream.readObject());
                    CHAMPIONSHIP_RACES.add((Race) objectInputStream2.readObject());

                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        catch (FileNotFoundException e){
            System.out.println();
        }
        catch (EOFException e) {
            System.out.println();
        }
    }

    /**
     *
     * @return driver arraylist
     */
    public static ArrayList<Formula1Driver> getDriverDetails(){
        return FORMULA_1_DRIVERS;
    }

    /**
     *
     * @return race details arraylist
     */
    public static ArrayList<Race> getRaceDetails(){
        return CHAMPIONSHIP_RACES;
    }
}