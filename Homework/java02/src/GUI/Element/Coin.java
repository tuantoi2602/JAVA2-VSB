package GUI.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.SpriteType;
import LauchMap.Status;

public class Coin extends Sprite {

  public Coin(int x, int y) {
    super();
    this.status = Status.THROUGH;
    this.x = x;
    this.y = y;
    this.type = SpriteType.COIN;

    try {
      this.image = ImageIO.read(new File("image/05.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
