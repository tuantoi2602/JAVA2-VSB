package ControlInput;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import ControlInput.ControlInputInterface.ControlInterface;
import GUI.Audio;
import GUI.Gate;
import GUI.Map;
import GUI.SpriteType;
import GUI.Dig.Dig;
import GUI.Interface.PanelInterface;
import GUI.Interface.SpriteInterface;
import LauchMap.PlayerMove;
import LauchMap.Status;

@SuppressWarnings("deprecation")
public class Control implements ControlInterface, Observer {
  private PlayerMove player = null;
  private int size = 0, col = 0, row = 0;
  private final int Coins = 0;
  private final PanelInterface panel;
  private final SpriteInterface sprite;
  private final Map map;
  private final Dig move;
  private final Gate gate;
  private final Audio backgroundSound;
  private final Audio coinSound;
  private Audio gameOver;
  private final Audio victorySound;
  private final EndGame end;

  public Control(SpriteInterface sprite, PanelInterface panel, int size,
      Map map, EndGame end, Audio backgroundSound) {
    this.panel = panel;
    this.sprite = sprite;
    this.size = size;
    this.map = map;

    this.move = new Dig(map.getSprites(), size, panel);
    this.gate = new Gate();
    this.backgroundSound = backgroundSound;
    backgroundSound.Sound(new File("music/background.wav"), -30.0f);
    this.coinSound = new Audio();
    this.victorySound = new Audio();
    this.end = end;
  }

  public final void directionControl() throws InterruptedException {
    if (this.sprite.getType() == SpriteType.PLAYER) {

      this.move.setVictory(false);
      this.move.gameOver(false);

      this.col = this.sprite.getX() / this.size;
      this.row = this.sprite.getY() / this.size;

      switch (this.getPlayer()) {
        case RIGHT:
          this.map.setSprites(this.move.digRight(this.col, this.row,
              this.sprite, this.coinSound));
          break;
        case LEFT:
          this.map.setSprites(this.move.digLeft(this.col, this.row, this.sprite,
              this.coinSound));
          break;
        case DOWN:
          this.map.setSprites(this.move.digDown(this.col, this.row, this.sprite,
              this.coinSound));
          break;
        case UP:
          this.map.setSprites(
              this.move.digUp(this.col, this.row, this.sprite, this.coinSound));
          break;
      }

      if (this.move.isGameOver()) {
        this.end.gameOver(this.gameOver);
      }

      if (this.panel.getCoinsGet() >= this.Coins) {
        setGate(this.map.getSprites());
      }

      if (this.move.isVictory()) {
        this.backgroundSound.Sound();
        this.gate.BrickBackgroundCoin(this.map.getSprites(), this.size);
        this.end.victory(this.victorySound);
      }
      this.panel.update();
    }
  }

  public PlayerMove getPlayer() {
    return this.player;
  }

  @Override
  public void update(Observable obs, Object obj) {
    if (obs instanceof Keyboard) {
      try {
        directionControl();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void setGate(SpriteInterface[][] sprites) {
    for (SpriteInterface[] unSprite : sprites) {
      for (SpriteInterface Sprite : unSprite) {
        if (Sprite.getType() == SpriteType.GATE) {
          Sprite.setStatus(Status.THROUGH);
        }
      }
    }
  }

  @Override
  public void setControl(PlayerMove player) {
    this.player = player;

  }
}
