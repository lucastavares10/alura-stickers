import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImDbExtractor implements Extractor {

  public List<Content> extract(String json) {

    JsonParser jparser = new JsonParser();

    List<Map<String, String>> dataList = jparser.parse(json);

    List<Content> contentList = new ArrayList<>();

    dataList.forEach((data) -> {
      String imageUrl = data.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

      contentList.add(new Content(data.get("fullTitle"), imageUrl));
    });

    return contentList;
  }

}
