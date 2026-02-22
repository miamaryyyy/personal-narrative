import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  private ImageFilter[][] images;
  private String[][] names;

  public SceneTwo(ImageFilter[][] images, String[][] names) {
    this.images = images;
    this.names = names;
  }

  public void drawScene() {
    clear("yellow");
    drawText("Scene 2", 100, 100);

    for (int row = 0; row < images.length; row++) {
      for (int col = 0; col < images[0].length; col++) {

    if (images[row][col] != null) {
          drawText(names[row][col], 100, 80);

    images[row][col].applySepia();
 drawImage(images[row][col], 0, 0, 400, 400, 0);
    pause(1);

 images[row][col].colorize();
   drawImage(images[row][col], 0, 0, 400, 400, 0);
     pause(1);
        }
      }
    }
  }
}