package GUI.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.SpriteType;
import LauchMap.Status;

public class Brick extends Sprite {

  public Brick(int x, int y) {
    super();
    this.status = Status.BLOCKING;
    this.x = x;
    this.y = y;
    this.type = SpriteType.BRICK;

    try {
      this.image = ImageIO.read(new File("image/04.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
