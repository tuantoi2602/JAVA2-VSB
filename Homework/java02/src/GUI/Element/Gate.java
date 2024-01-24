package GUI.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.SpriteType;
import LauchMap.Status;

public class Gate extends Sprite {

  public Gate(int x, int y) {
    super();
    this.status = Status.BLOCKING;
    this.x = x;
    this.y = y;
    this.type = SpriteType.GATE;

    try {
      this.image = ImageIO.read(new File("image/06.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
