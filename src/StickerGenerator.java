import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.imageio.ImageIO;

public class StickerGenerator {

  public void create() throws Exception {

    BufferedImage originalImage = ImageIO.read(new File("img/filme.jpg"));

    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;

    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) newImage.getGraphics();

    graphics.drawImage(originalImage, 0, 0, null);

    graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

    graphics.setColor(Color.YELLOW);

    graphics.drawString("TOPZERA", 150, newHeight - 100);

    ImageIO.write(newImage, "png", new File("img/figurinha.png"));

  }

  public static void main(String[] args) throws Exception {

    StickerGenerator stickerGenerator = new StickerGenerator();

    stickerGenerator.create();

  }

}
