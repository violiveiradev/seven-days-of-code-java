import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ClientHttp {

    public static void main(String[] args) throws IOException, InterruptedException{

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/<apiKey>"))
            .timeout(Duration.ofSeconds(4))
            .build();

    
        HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(3))
            .followRedirects(Redirect.NORMAL)
            .build();
        
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
//        System.out.println(response.statusCode());
//        System.out.println(response.headers());
//        System.out.println(response.version());

    }
    
}

