package GUI.Dig;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Element.Background;
import GUI.Element.Brick;
import GUI.Interface.AudioInterface;
import GUI.Interface.PanelInterface;
import GUI.Interface.SpriteInterface;

public class DigLeft extends Dig {

  public DigLeft(SpriteInterface[][] sprites, int SET_SIZE,
      PanelInterface panel) {
    super(sprites, SET_SIZE, panel);
  }

  public SpriteInterface[][] goLeft(int col, int row, SpriteInterface sprite,
      SpriteInterface[][] sprites, PanelInterface panel, AudioInterface audio) {
    try {
      this.image = ImageIO.read(new File("image/g1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (nextCoin(sprites[row][col - 1])) {
      panel.setCoinsGet(panel.getCoinsGet() + 1);
      panel.setScore(panel.getScore() + 1000);
      audio.Sound(new File("music/coin.wav"), 40.0f);
    }
    if (nextOpenedGate(sprites[row][col - 1])) {
      panel.setScore(panel.getScore() + 10000);
      setVictory(true);
    }
    if (nextRock(sprites[row][col - 1])
        && nextBackground(sprites[row][col - 2])) {
      sprites[row][col] = new Background(sprite.getX(), sprite.getY());
      sprite.setX(sprite.getX() - 16);
      sprite.setImage(this.image);
      sprites[row][col - 1] = sprite;
      sprites[row][col - 2] = new Brick(sprite.getX() - 16, sprite.getY());
      return sprites;
    } else if (isSpriteOn(sprites[row][col - 1])) {
      audio.Sound(new File("music/touch.wav"), 40.0f);
      return sprites;
    }

    else {
      sprites[row][col] = new Background(sprite.getX(), sprite.getY());
      sprite.setX(sprite.getX() - 16);
      sprite.setImage(this.image);
      sprites[row][col - 1] = sprite;
      return sprites;
    }

  }
}
