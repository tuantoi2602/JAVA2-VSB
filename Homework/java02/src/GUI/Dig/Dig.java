package GUI.Dig;

import java.awt.Image;

import GUI.SpriteType;
import GUI.Interface.AudioInterface;
import GUI.Interface.MoveInterface;
import GUI.Interface.PanelInterface;
import GUI.Interface.SpriteInterface;
import LauchMap.Status;

public class Dig implements MoveInterface {
  protected SpriteInterface[][] sprites;
  protected int size;
  protected PanelInterface panel;
  protected boolean gameOver = false;
  protected static boolean victory = true;
  protected Image image;

  public Dig(SpriteInterface[][] sprites, int size, PanelInterface panel) {
    this.sprites = sprites;
    this.size = size;
    this.panel = panel;
  }

  @Override
  public SpriteInterface[][] digLeft(int col, int row, SpriteInterface sprite,
      AudioInterface audio) {
    DigLeft left = new DigLeft(this.sprites, row, this.panel);
    return left.goLeft(col, row, sprite, this.sprites, this.panel, audio);
  }

  @Override
  public SpriteInterface[][] digRight(int col, int row, SpriteInterface sprite,
      AudioInterface audio) {
    DigRight right = new DigRight(this.sprites, row, this.panel);
    return right.goRight(col, row, sprite, this.sprites, this.panel, audio);
  }

  @Override
  public SpriteInterface[][] digUp(int col, int row, SpriteInterface sprite,
      AudioInterface audio) {
    DigUp up = new DigUp(this.sprites, row, this.panel);
    return up.goUp(col, row, sprite, this.sprites, this.panel, audio);

  }

  @Override
  public SpriteInterface[][] digDown(int col, int row, SpriteInterface sprite,
      AudioInterface audio) {
    DigDown down = new DigDown(this.sprites, row, this.panel);
    return down.goDown(col, row, sprite, this.sprites, this.panel, audio);
  }

  public Boolean isSpriteOn(SpriteInterface sprite) {
    return sprite.getStatus() == Status.BLOCKING;
  }

  public Boolean nextCoin(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.COIN;
  }

  @Override
  public Boolean nextBackground(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.BACKGROUND;
  }

  public Boolean nextRock(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.BRICK;
  }

  public Boolean nextOpenedGate(SpriteInterface sprite) {
    return sprite.getType() == SpriteType.GATE
        && sprite.getStatus() == Status.THROUGH;
  }

  @Override
  public void gameOver(boolean gameOver) {
  }

  @Override
  public boolean isGameOver() {
    return this.gameOver;
  }

  @Override
  public boolean isVictory() {
    return victory;
  }

  @Override
  public void setVictory(boolean victory) {
    Dig.victory = victory;
  }
}
