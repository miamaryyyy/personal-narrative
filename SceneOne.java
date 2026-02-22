import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  private ImageFilter[][] images;
  private String[][] names;

  public SceneOne(ImageFilter[][] images, String[][] names) {
    this.images = images;
    this.names = names;
  }

  public void drawScene() {
    clear("pink");
    drawText("Scene 1", 100, 100);

    for (int row = 0; row < images.length; row++) {
      for (int col = 0; col < images[0].length; col++) {

    if (images[row][col] != null) {

     drawText(names[row][col], 100, 80);

    drawImage(images[row][col], 0, 0, 400, 400, 0);
        pause(1);

    images[row][col].mirrorVertical();
    drawImage(images[row][col], 0, 0, 400, 400, 0);
    pause(1);

    images[row][col].makeNegative();
    drawImage(images[row][col], 0, 0, 400, 400, 0);
          pause(1);
        }
      }
    }
  }
}