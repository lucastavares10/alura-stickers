import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaExtractor implements Extractor {

  public List<Content> extract(String json) {

    JsonParser jparser = new JsonParser();

    List<Map<String, String>> dataList = jparser.parse(json);

    List<Content> contentList = new ArrayList<>();

    dataList.forEach((data) -> {
      contentList.add(new Content(data.get("title"), data.get("url")));
    });

    return contentList;
  }

}
