import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

        URI endereco = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        JsonParser jparser = new JsonParser();

        List<Map<String, String>> movieList = jparser.parse(body);

        StickerGenerator generator = new StickerGenerator();

        for (int i = 0; i < movieList.size(); i++) {

            Map<String, String> movie = movieList.get(i);

            String imageUrl = movie.get("url");
            String fileName = movie.get("title") + ".png";

            InputStream inputStream = new URL(imageUrl).openStream();

            generator.create(inputStream, fileName);

        }

    }
}
