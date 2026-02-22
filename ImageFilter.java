import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /** Instance Variables */
  
  /** Constructor**/

 
  public ImageFilter(String filename) {
    super(filename);
  }

  /*
   * Mirrors the image vertically
   */
  public void mirrorVertical() {
    Pixel[][] pixels = getImagePixels();
    
    for (int row = 0; row < pixels.length; row++) {
      // mirroring at the half way mark, so half cols
      for (int col = 0; col < pixels[0].length / 2; col++) {
        // left pixel is just the the current pixel in traversal
        Pixel leftPixel = pixels[row][col];
        // right pixel is the same distance from the right side
        // as the left pixel is from the left
        // so find the difference of the total col - current col - 1 (zero indexed)
        Pixel rightPixel = pixels[row][pixels[0].length - col - 1];

        // set the left pixel's color to the right's color
        Color rightColor = rightPixel.getColor();
        leftPixel.setColor(rightColor);
      }
    }
    
  }
  
  // Add filter methods here...
//negative
  public void makeNegative() {
    Pixel[][] pixels = this.getImagePixels();
    for (int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[0].length; col++) {
        Pixel pixel = pixels[row][col];
        pixel.setRed(255 - pixel.getRed());
        pixel.setGreen(255 - pixel.getGreen());
        pixel.setBlue(255 - pixel.getBlue());
}
}
}
 
//sepia
 public void applySepia() {
    Pixel[][] pixels = this.getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {

        Pixel pixel = pixels[row][col];

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

        if (newRed > 255) newRed = 255;
        if (newRed < 0) newRed = 0;

        if (newGreen > 255) newGreen = 255;
        if (newGreen < 0) newGreen = 0;

        if (newBlue > 255) newBlue = 255;
        if (newBlue < 0) newBlue = 0;

        pixel.setRed(newRed);
        pixel.setGreen(newGreen);
        pixel.setBlue(newBlue);
      }
    }
 }

//colorize
     public void colorize() {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {

        Pixel pixel = pixels[row][col];

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int average = (red + green + blue) / 3;

        if (average < 85) {
          pixel.setRed(255);
          pixel.setGreen(0);
          pixel.setBlue(0);
        }
        else if (average < 170) {
          pixel.setRed(0);
          pixel.setGreen(255);
          pixel.setBlue(0);
        }
        else {
          pixel.setRed(0);
          pixel.setGreen(0);
          pixel.setBlue(255);
        }
      }
    }

  
}

}