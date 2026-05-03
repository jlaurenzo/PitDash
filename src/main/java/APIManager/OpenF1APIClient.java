package APIManager;

import Drivers.DriversPage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenF1APIClient {
    private final HttpClient client;

    public OpenF1APIClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String getDrivers(String session_key) throws Exception {

        boolean per_Year = new DriversPage().perYear;
        HttpRequest request;

        if (per_Year) {
            request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openf1.org/v1/drivers?session_key=" + session_key))
                .GET()
                .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } else {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.openf1.org/v1/drivers"))
                    .GET()
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        }
    }


}
