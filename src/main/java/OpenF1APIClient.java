import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class OpenF1APIClient {
    private final HttpClient client;

    public OpenF1APIClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String getDrivers() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openf1.org/v1/drivers?session_key=latest"))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }


}
