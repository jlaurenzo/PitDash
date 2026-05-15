package Drivers;

import APIManager.OpenF1APIClient;
import APIManager.OpenF1Service;

import java.util.*;

public class DriverByTeam {
    String firstName;
    String lastName;
    String nameAcronym;
    String team;
    int driverNumber;

    public DriverByTeam(String firstName, String lastName, String nameAcronym, String team, int driverNumber) { //THIS IS THE CONSTRUCTOR FOR OUR OBJECT
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameAcronym = nameAcronym;
        this.team = team;
        this.driverNumber = driverNumber;
    }

    @Override
    public String toString() {
        return  "#" + driverNumber + " " +firstName + " " + lastName + " (" + nameAcronym + ")" ;
    }


    public static void filterDriversByTeam(List<String> sessionKeys) throws Exception {

        OpenF1APIClient f1API = new OpenF1APIClient();
        OpenF1Service parser = new OpenF1Service();

        List<String> allJson = f1API.getDrivers(sessionKeys);

        List<DriverByTeam> uniqueDrivers = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String json : allJson) {                        // loop each session's JSON
            List<DriverByTeam> drivers = parser.parseDriversbyTeam(json);
            for (DriverByTeam d : drivers) {
                if (seen.add(d.driverNumber)) {
                    uniqueDrivers.add(d);
                }
            }
        }

        Map<String, List<DriverByTeam>> byTeam = new LinkedHashMap<>();
        for (DriverByTeam d : uniqueDrivers) {
            byTeam.computeIfAbsent(d.team, k -> new ArrayList<>()).add(d);
        }

        // Print grouped by team
        for (Map.Entry<String, List<DriverByTeam>> entry : byTeam.entrySet()) {
            System.out.println("\n"+ entry.getKey());  // team name header
            System.out.println("------------------------------------");

            for (DriverByTeam d : entry.getValue()) { // loop through the drivers under that team
                System.out.println(" " + d);
            }
        }
    }
}
