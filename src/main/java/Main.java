import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.*;


public class Main {
    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.openf1.org/v1/drivers?session_key=latest"))
                    .GET()
                    .build();

            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }


        JsonArray drivers = JsonParser.parseString(response.body()).getAsJsonArray();

        for (JsonElement d : drivers) {
            JsonObject driver = d.getAsJsonObject();

            String fname = driver.get("first_name").getAsString();
            String lname = driver.get("last_name").getAsString();
            String dacronym = driver.get("name_acronym").getAsString();
            int dnumber = driver.get("driver_number").getAsInt();
            String team = driver.get("team_name").getAsString();

            System.out.println(fname +" "+ lname + " (" + dacronym +") " + " #" + dnumber + " - " + team);
        }
        Home.showHome();

    }
}