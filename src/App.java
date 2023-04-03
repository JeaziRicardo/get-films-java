import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws Exception {
        var prop = new Properties();
        var star = new Star();
        var client = new ClientHTTP();

        prop.load(new FileInputStream("config.properties"));
        String URL_API = prop.getProperty("URL_API");

        String url = URL_API;
        var body = client.getData(url);

        var parser = new JsonParser();
        List<Map<String, String>> films = parser.parse(body);

        for (Map<String,String> film : films) {
            System.out.format("\u001b[1m\u001b[92m\u001b[103m%s \u001b[m \n", film.get("title"));
            System.out.println(film.get("image"));
            System.out.println(star.starring(film.get("imDbRating")));
            System.out.println(film.get("imDbRating"));
            System.out.println();
        }
    }
}
