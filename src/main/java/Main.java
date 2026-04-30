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

            String name = driver.get("full_name").getAsString();
            int dNumber = driver.get("driver_number").getAsInt();
            String team = driver.get("team_name").getAsString();

            System.out.println(name + "#" + dNumber + " - " + team);
        }
    }
}