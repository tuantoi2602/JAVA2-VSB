package GUI;

import java.io.File;

import GUI.Element.Background;
import GUI.Interface.AudioInterface;
import GUI.Interface.GravityInterface;
import GUI.Interface.PanelInterface;
import GUI.Interface.SpriteInterface;

public class Gravity implements GravityInterface {
  private int row = 0, col = 0;
  private boolean gameOver = false;

  @Override
  public SpriteInterface[][] BrickCoinFall(SpriteInterface[][] sprites,
      AudioInterface audio, PanelInterface panel) {
    this.row = 0;
    for (SpriteInterface[] unSpirte : sprites) {
      this.col = 0;
      for (SpriteInterface spirte : unSpirte) {
        if (spirte.getType() == SpriteType.COIN
            || spirte.getType() == SpriteType.BRICK) {
          if (SpriteBackground(sprites[this.row + 1][this.col])
              && !spirte.HasMoved()) {
            sprites[this.row][this.col] =
                new Background(spirte.getX(), spirte.getY());
            spirte.setY(spirte.getY() + 16);
            spirte.setHasMoved(true);
            spirte.setBlocked(false);
            sprites[this.row + 1][this.col] = spirte;
          } else if (AbovePlayer(sprites[this.row + 1][this.col])
              && !spirte.HasMoved() && spirte.HasAbovePlayer()
              && !spirte.isBlocked()) {
                sprites[this.row][this.col] =
                    new Background(spirte.getX(), spirte.getY());
                spirte.setY(spirte.getY() + 16);
                spirte.setHasMoved(true);
                sprites[this.row + 1][this.col] = spirte;
                audio.Sound(new File("music/die.wav"), 30.0f);
                gameOver();
              } else
            if (AbovePlayer(sprites[this.row + 1][this.col])
                && !spirte.HasMoved() && !spirte.HasAbovePlayer()) {
                  spirte.sethasAbovePlayer(true);
                  spirte.setBlocked(true);
                } else
              if (isSpriteAboveDirt(sprites[this.row + 1][this.col])) {
                spirte.sethasAbovePlayer(false);
              }
        }
        this.col++;
      }
      this.row++;
    }
    return sprites;
  }

  @Override
  public SpriteInterface[][] BrickCoinSlide(SpriteInterface[][] sprites) {
    this.row = 0;
    for (SpriteInterface[] unspirte : sprites) {
      this.col = 0;
      for (SpriteInterface spirte : unspirte) {
        if ((spirte.getType() == SpriteType.COIN
            || spirte.getType() == SpriteType.BRICK)
            && DirtCoin(sprites[this.row + 1][this.col])) {
          if (SpriteBackground(sprites[this.row][this.col + 1])
              && SpriteBackground(sprites[this.row + 1][this.col + 1])) {
            sprites[this.row][this.col] =
                new Background(spirte.getX(), spirte.getY());
            spirte.setX(spirte.getX() + 16);
            sprites[this.row][this.col + 1] = spirte;
          } else if (SpriteBackground(sprites[this.row][this.col - 1])
              && SpriteBackground(sprites[this.row + 1][this.col - 1])) {
                sprites[this.row][this.col] =
                    new Background(spirte.getX(), spirte.getY());
                spirte.setX(spirte.getX() - 16);
                sprites[this.row][this.col - 1] = spirte;
              }
        }
        this.col++;
      }
      this.row++;
    }
    return sprites;
  }

  public Boolean DirtCoin(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.BRICK
        || sprite.getType() == SpriteType.COIN;
  }

  @Override
  public Boolean SpriteBackground(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.BACKGROUND;
  }

  public Boolean AbovePlayer(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.PLAYER;
  }

  public Boolean isSpriteAboveDirt(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.DIRT;
  }

  public void gameOver() {
    this.gameOver = true;
  }

  @Override
  public boolean isGameOver() {
    return this.gameOver;
  }
}
