import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

    public static void main(String[] args) throws IOException, InterruptedException{

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/<apiKey>"))
            .build();

    
        HttpClient httpClient = HttpClient.newBuilder()
            .build();
        
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        System.out.println(response.body());

    }
    
}
