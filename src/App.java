import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws Exception {
        var prop = new Properties();

        prop.load(new FileInputStream("config.properties"));
        String URL_API = prop.getProperty("URL_API");

        String url = URL_API;
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> filmsList = parser.parse(body);

        for (Map<String,String> film : filmsList) {
            System.out.format("\u001b[1m\u001b[92m\u001b[103m%s \u001b[m \n", film.get("title"));
            System.out.println(film.get("image"));
            System.out.println(film.get("imDbRating"));
            System.out.println();
        }
    }
}
