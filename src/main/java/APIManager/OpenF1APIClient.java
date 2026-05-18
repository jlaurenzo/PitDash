package APIManager;

import Drivers.DriversPage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class OpenF1APIClient {
    private final HttpClient client;

    public OpenF1APIClient() {
        this.client = HttpClient.newHttpClient();
    }

    public List<String> getDrivers(List<String> sessionKeys) throws Exception {
        List<String> allResponses = new ArrayList<>();

        HttpRequest request = null;

        for (String session_key : sessionKeys) {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.openf1.org/v1/drivers?session_key=" + session_key))
                    .GET()
                    .build();
            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            allResponses.add(response); // collect each session's response
        }
        return allResponses;
    }

    public List<String> getDriverStanding(List<String> sessionKeys) throws Exception {

        List<String> allResponses = new ArrayList<>();
        HttpRequest request = null;

        for (String session_key : sessionKeys) {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.openf1.org/v1/championship_drivers?session_key=" + session_key))
                    .GET()
                    .build();
            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            allResponses.add(response);
        }
        return allResponses;
    }




    }
