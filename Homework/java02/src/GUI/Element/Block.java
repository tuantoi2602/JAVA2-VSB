package GUI.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.SpriteType;
import LauchMap.Status;

public class Block extends Sprite {

  public Block(int x, int y) {
    super();
    this.status = Status.BLOCKING;
    this.x = x;
    this.y = y;
    this.type = SpriteType.BLOCK;

    try {
      this.image = ImageIO.read(new File("image/01.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
