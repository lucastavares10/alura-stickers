public class Content {

  private String title;
  private String contentUrl;

  public Content() {
  }

  public Content(String title, String contentUrl) {
    this.title = title;
    this.contentUrl = contentUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContentUrl() {
    return contentUrl;
  }

  public void setContentUrl(String contentUrl) {
    this.contentUrl = contentUrl;
  }

}
