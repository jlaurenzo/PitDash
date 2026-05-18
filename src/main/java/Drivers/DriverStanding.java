package Drivers;

import APIManager.OpenF1APIClient;
import APIManager.OpenF1Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DriverStanding {
    int driverNumber;
    int pointsCurrent;
    int pointsBefore;
    int positionCurrent;
    int positionBefore;

    public DriverStanding (int driverNumber, int pointsCurrent, int pointsBefore, int positionCurrent, int positionBefore) {
        this.driverNumber = driverNumber;
        this.pointsCurrent = pointsCurrent;
        this.pointsBefore = pointsBefore;
        this.positionCurrent = positionCurrent;
        this.positionBefore = positionBefore;
    }

    @Override
    public String toString() {

        int positionChange = positionBefore - positionCurrent;
        String positionchangeSymbol = "";
        if (positionChange < 0){
            positionchangeSymbol ="↓";
        } else if (positionChange >0) {
            positionchangeSymbol = "↑";
        }

        return "\t\t#" + driverNumber +"\t\t\t" + pointsCurrent + "\t\t\t" + positionchangeSymbol + " " + positionChange;


    }


    public static void showFinalDriverStanding(List<String> sessionKeys) throws Exception {

        OpenF1APIClient f1API = new OpenF1APIClient();
        OpenF1Service parser = new OpenF1Service();

        List<String> allJson = f1API.getDriverStanding(sessionKeys);

        List<DriverStanding> driverStanding = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String json : allJson) {                        // loop each session's JSON
            List<DriverStanding> driverStandings = parser.parseDriverStanding(json);
            for (DriverStanding d : driverStandings) {
                if (seen.add(d.driverNumber)) {
                    driverStanding.add(d);
                }
            }
        }

        System.out.println("Rank\t" + "Driver No. \t" +"Points \t"+"Position Change");

        int i = 1;
        for (DriverStanding driverStandingElement : driverStanding) {
            System.out.println(i + ""+ driverStandingElement);
            i++;
        }
    }
}
