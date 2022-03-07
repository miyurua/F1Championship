package w1761114;

import java.io.Serializable;
import java.util.Date;


public class Race implements Serializable{
    protected Date date;
    protected int raceNum;
    protected String winTeam;
    protected String teamName;
    protected int numOfDrivers;
    protected int raceRank;
    protected Object[] raceObjectData;
    protected Formula1Driver[] driverPosition = new Formula1Driver[numOfDrivers];
    private static final long serialVersionUID = 1L;

    public Race(){
    }

    public Race(Date date, String teamName, int raceRank, int numOfDrivers){
        this.date = date;
        this.teamName = teamName;
        this.raceRank = raceRank;
        this.numOfDrivers = numOfDrivers;
    }

    //Getters

    //Getter for Date
    public Date getDate() {
        return date;
    }

    public int getRaceNum() {
        return raceNum;
    }

    public String getWinTeam() {
        return winTeam;
    }

    //Getter for Team Name
    public String getTeamName() {
        return teamName;
    }

    //Getter for Race Rank
    public int getRaceRank() {
        return raceRank;
    }

    //Getter for num of Drivers
    public int getNumOfDrivers() {
        return numOfDrivers;
    }

    public Formula1Driver[] getDriverPosition(Formula1Driver[] driverPosition) {
        return this.driverPosition;
    }

    //Getter for race object data

    public Object[] getRaceObjectData() {
        return raceObjectData;
    }


    //Setters

    //Setter for Date
    public void setDate(Date date) {
        this.date = date;
    }

    public void setRaceNum(int raceNum) {
        this.raceNum = raceNum;
    }

    public void setWinTeam(String winTeam) {
        this.winTeam = winTeam;
    }

    //Setter for TeamName
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setNumOfDrivers(int numOfDrivers){
        this.numOfDrivers = numOfDrivers;
    }

    //Setter for Race Rank
    public void setRaceRank(int raceRank) {
        this.raceRank = raceRank;
    }

    public void setDriverPosition(Formula1Driver[] driverPosition) {
        this.driverPosition = driverPosition;
    }

    public void setRaceObjectData(){
        Object[] raceData = new Object[5];
        raceData[0] = this.getDate();
        raceData[1] = this.getTeamName();
        raceData[2] = this.getRaceRank();
        raceData[3] = this.getNumOfDrivers();
        raceData[4] = this.getWinTeam();

        this.raceObjectData = raceData;

    }

    /**
     *
     * @return toString method for the Race Class
     */
    @Override
    public String toString(){
        return "\nRace{" +
                "| Date : " + getDate() +
                "| Team Name : " + getTeamName() +
                "| Team Rank : " + getRaceRank() +
                "}";
    }

}