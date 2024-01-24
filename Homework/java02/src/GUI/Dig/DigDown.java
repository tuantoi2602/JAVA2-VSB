package GUI.Dig;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Element.Background;
import GUI.Interface.AudioInterface;
import GUI.Interface.PanelInterface;
import GUI.Interface.SpriteInterface;

public class DigDown extends Dig {

  public DigDown(SpriteInterface[][] sprites, int SET_SIZE,
      PanelInterface panel) {
    super(sprites, SET_SIZE, panel);
  }

  public SpriteInterface[][] goDown(int col, int row, SpriteInterface sprite,
      SpriteInterface[][] sprites, PanelInterface panel, AudioInterface audio) {
    try {
      this.image = ImageIO.read(new File("image/13.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (nextCoin(sprites[row + 1][col])) {
      panel.setCoinsGet(panel.getCoinsGet() + 1);
      panel.setScore(panel.getScore() + 1000);
      audio.Sound(new File("music/coin.wav"), 40.0f);
    }
    if (nextOpenedGate(sprites[row + 1][col])) {
      panel.setScore(panel.getScore() + 10000);
      setVictory(true);
    }
    if (isSpriteOn(sprites[row + 1][col])) {
      audio.Sound(new File("music/touch.wav"), 40.0f);
      return sprites;
    } else {
      sprites[row][col] = new Background(sprite.getX(), sprite.getY());
      sprite.setY(sprite.getY() + 16);
      sprite.setImage(this.image);
      sprites[row + 1][col] = sprite;
      return sprites;
    }
  }
}
