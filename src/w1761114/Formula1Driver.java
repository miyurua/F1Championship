package w1761114; 

public class Formula1Driver extends Driver{

    protected int firstPositions = 0;
    protected int secondPositions = 0;
    protected int thirdPositions = 0;
    protected int seasonPoints = 0;
    protected int numOfRaces = 0;
    protected Object[] driverObjectData;
    private static final long serialVersionUID = 1L;


    /**
     * Default Constructor for Formula1Driver
     */
    public Formula1Driver(){
    }

    /**
     *
     * @param driverName Driver's Name
     * @param driverAge Driver's Age
     * @param driverLocation Driver's Location
     * @param driverNationality Driver's Nationality
     * @param driverTeam Driver's Team
     */
    public Formula1Driver(String driverName, int driverAge, String driverLocation, String driverNationality,
                          String driverTeam) {
        super(driverName, driverAge, driverNationality, driverLocation, driverTeam);
    }

//Getters

    /**
     *
     * @return first position
     */
    public int getFirstPositions() {
        return firstPositions;
    }

    /**
     *
     * @return second position
     */
    public int getSecondPositions() {
        return secondPositions;
    }

    /**
     *
     * @return third position
     */
    public int getThirdPositions() {
        return thirdPositions;
    }

    /**
     *
     * @return season points
     */
    public int getSeasonPoints() {
        return seasonPoints;
    }

    /**
     *
     * @return number of Races
     */
    public int getNumOfRaces() {
        return numOfRaces;
    }

    /**
     *
     * @return Driver data
     */
    public Object[] getDriverObjectData() {
        return driverObjectData;
    }

//Setters

    public void addFirstPositionCount(){
        this.firstPositions++;
    }

    public void addSecondPositionsCount() {
        this.secondPositions++;
    }

    public void addThirdPositionsCount() {
        this.thirdPositions++;
    }

    public void addNumOfRaces(){this.numOfRaces++;}

    public void setSeasonPoints(int points) {
        this.seasonPoints += points;
    }

    public void setDriverObjectData(){
        Object[] data = new Object[7];
        data[0] = this.getDriverName();
        data[1] = this.getDriverTeam();
        data[2] = this.getSeasonPoints();
        data[3] = this.getFirstPositions();
        data[4] = this.getSecondPositions();
        data[5] = this.getThirdPositions();
        data[6] = this.getNumOfRaces();

        this.driverObjectData = data;
    }

    /**
     *
     * @return toString Method for the Formula1Driver Class
     */
    @Override
    public String toString(){
        return
                " Driver Name: " + getDriverName()   +
                "| Driver Team: " + getDriverTeam()   +
                "| Driver Age : " + getDriverAge()    +
                "| Driver Location : "+ getDriverLocation() +
                "| Driver Nationality : " + getDriverNationality() +
                "| Season Points :" + getSeasonPoints() +
                "| Number of First Positions: " + firstPositions +
                "| Number of Second Positions : " + secondPositions +
                "| Number of Third Positions  : " + thirdPositions +
                "| Number of Races : " + numOfRaces +
                "\n";
    }

    //Display Driver Individual Stats Method.
    public void displayStats() {
        System.out.println(
                  "Driver Name                  : " + getDriverName() +
                "\nDriver Team                  : " + getDriverTeam()   +
                "\nDriver Age                   : " + getDriverAge()    +
                "\nDriver Location              : " + getDriverLocation() +
                "\nDriver Nationality           : " + getDriverNationality() +
                "\nSeason Points                : " + getSeasonPoints() +
                "\nNumber of First Positions    : " + firstPositions +
                "\nNumber of Second Positions   : " + secondPositions +
                "\nNumber of Third Positions    : " + thirdPositions +
                "\nNumber of Races              : " + numOfRaces);
    }

    @Override
    public void seasonPoints(int fixedRaceWinPoint) {
    }
}