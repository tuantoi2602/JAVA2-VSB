package GUI.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.SpriteType;
import LauchMap.Status;

public class Dirt extends Sprite {

  public Dirt(int x, int y) {
    super();
    this.status = Status.THROUGH;
    this.x = x;
    this.y = y;
    this.type = SpriteType.DIRT;

    try {
      this.image = ImageIO.read(new File("image/02.gif"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
