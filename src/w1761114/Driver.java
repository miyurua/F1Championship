package w1761114;

import java.io.Serializable;

public abstract class Driver implements Serializable{

    String driverName;
    int driverAge;
    String driverNationality;
    String driverLocation;
    String driverTeam;

    /**
     * Default Constructor
     */
    public Driver(){
    }

    /**
     *
     * @param driverName Name of the Driver.
     * @param driverAge Age of the Driver.
     * @param driverLocation Location the Driver is from.
     * @param driverNationality Nationality of the Driver.
     * @param driverTeam Car Manufacturer of the Driver.
     */
    public Driver(String driverName, int driverAge, String driverNationality, String driverLocation, String driverTeam){
        this.driverName = driverName;
        this.driverAge = driverAge;
        this.driverNationality = driverNationality;
        this.driverLocation = driverLocation;
        this.driverTeam = driverTeam;
    }

    //Getters

    /**
     *
     * @return Driver's Name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     *
     * @return Driver's Age
     */
    public int getDriverAge() {
        return driverAge;
    }

    /**
     *
     * @return Driver's Nationality
     */
    public String getDriverNationality() {
        return driverNationality;
    }

    /**
     *
     * @return Driver's Location
     */
    public String getDriverLocation() {
        return driverLocation;
    }

    /**
     *
     * @return Driver's Team
     */
    public String getDriverTeam() {
        return driverTeam;
    }


    //Setters


    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public void setDriverNationality(String driverNationality) {
        this.driverNationality = driverNationality;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public void setDriverTeam(String driverTeam) {
        this.driverTeam = driverTeam;
    }

    public abstract void seasonPoints(int fixedRaceWinPoint);
}