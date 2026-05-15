package Drivers;

import APIManager.OpenF1APIClient;
import APIManager.OpenF1Service;

import java.util.*;

public class Driver {
    String firstName;
    String lastName;
    String nameAcronym;
    String team;
    int driverNumber;

    public Driver(String firstName, String lastName, String nameAcronym, String team, int driverNumber) { //THIS IS THE CONSTRUCTOR FOR OUR OBJECT
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameAcronym = nameAcronym;
        this.team = team;
        this.driverNumber = driverNumber;
    }

    @Override
    public String toString() {
        return  "#" + driverNumber + " " +firstName + " " + lastName + " (" + nameAcronym + ") " + "\n - " + team;
    }

    public static void showDrivers(List<String> sessionKeys) throws Exception {

        OpenF1APIClient f1API = new OpenF1APIClient();
        OpenF1Service parser = new OpenF1Service();

        List<String> allJson = f1API.getDrivers(sessionKeys);

        List<Driver> uniqueDrivers = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String json : allJson) {                        // loop each session's JSON
            List<Driver> drivers = parser.parseDrivers(json);
            for (Driver d : drivers) {
                if (seen.add(d.driverNumber)) {
                    uniqueDrivers.add(d);
                }
            }
        }

        for (Driver driverElement : uniqueDrivers) {
            System.out.println(driverElement);
        }
    }



}

