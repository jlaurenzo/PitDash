import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

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
        return  "#" + driverNumber + " " +firstName + " " + lastName + " (" + nameAcronym + ") " + " " + team;
    }

    public static void showDrivers() throws Exception {
        OpenF1APIClient f1API = new OpenF1APIClient();
        OpenF1Service parser = new OpenF1Service();

        String json = f1API.getDrivers(); //fetch the data
        List<Driver> drivers = parser.parseDrivers(json);

        for (Driver driverElement : drivers) {
            System.out.println(driverElement);
        }

    }
}

