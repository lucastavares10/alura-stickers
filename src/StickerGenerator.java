import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {

  public void create(InputStream inputStream, String fileName) throws Exception {

    // InputStream inputStream = new FileInputStream(new File("img/filme.jpg"));
    // InputStream inputStream = new URL(
    // "https://m.media-amazon.com/images/M/MV5BNDJhYTk2MTctZmVmOS00OTViLTgxNjQtMzQxOTRiMDdmNGRjXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
    // .openStream();
    BufferedImage originalImage = ImageIO.read(inputStream);

    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;

    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) newImage.getGraphics();

    graphics.drawImage(originalImage, 0, 0, null);

    graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

    graphics.setColor(Color.YELLOW);

    graphics.drawString("TOPZERA", 150, newHeight - 100);

    ImageIO.write(newImage, "png", new File("img/" + fileName));

  }

}
