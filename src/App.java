import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        HttpService httpService = new HttpService();

        // Extractor nasaExtractor = new NasaExtractor();
        // String url =
        // "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        Extractor imDbExtractor = new ImDbExtractor();

        String json = httpService.getData(url);

        List<Content> contents = imDbExtractor.extract(json);

        StickerGenerator generator = new StickerGenerator();

        for (int i = 0; i < contents.size(); i++) {

            Content content = contents.get(i);

            String imageUrl = content.getContentUrl();
            String fileName = content.getTitle() + ".png";

            InputStream inputStream = new URL(imageUrl).openStream();

            generator.create(inputStream, fileName);

        }

    }
}
