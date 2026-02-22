import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    ImageFilter[][] images = {
      { new ImageFilter("bob.jpg"), new ImageFilter("dave.jpg") },
      { new ImageFilter("gus.png"), null },
      { new ImageFilter("stuart.jpg"), new ImageFilter("mel.png") }
    };

    // SECOND 2D ARRAY
    String[][] names = {
      { "Bob", "Dave" },
      { "Gus", "" },
      { "Stuart", "Mel" }
    };

    SceneOne scene1 = new SceneOne(images, names);
    SceneTwo scene2 = new SceneTwo(images, names);

    scene1.drawScene();
    scene2.drawScene();

    Theater.playScenes(scene1, scene2);
  }
}