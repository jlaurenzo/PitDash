package APIManager;

import Drivers.Driver;
import Drivers.DriverByTeam;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class OpenF1Service {

    public List<Driver> parseDrivers(String json) {

        List<Driver> driverList = new ArrayList<>();

        JsonArray drivers = JsonParser.parseString(json).getAsJsonArray();

        for (JsonElement element : drivers) {
            JsonObject driverOject = element.getAsJsonObject();

            Driver driver = new Driver(
                    driverOject.get("first_name").getAsString(),
                    driverOject.get("last_name").getAsString(),
                    driverOject.get("name_acronym").getAsString(),
                    driverOject.get("team_name").getAsString(),
                    driverOject.get("driver_number").getAsInt()
            );
            driverList.add(driver);
        }
        return driverList;
    }

    public List<DriverByTeam> parseDriversbyTeam(String json) {

        List<DriverByTeam> driverList = new ArrayList<>();

        JsonArray drivers = JsonParser.parseString(json).getAsJsonArray();

        for (JsonElement element : drivers) {
            JsonObject driverOject = element.getAsJsonObject();

            DriverByTeam driver = new DriverByTeam(
                    driverOject.get("first_name").getAsString(),
                    driverOject.get("last_name").getAsString(),
                    driverOject.get("name_acronym").getAsString(),
                    driverOject.get("team_name").getAsString(),
                    driverOject.get("driver_number").getAsInt()
            );
            driverList.add(driver);
        }
        return driverList;
    }


}
