package ControlInput;

import GUI.Audio;
import GUI.Gravity;
import GUI.Map;
import GUI.Interface.PanelInterface;

public class GamePlay {
  private final Map maker;
  private final Gravity gravity;
  private final Audio gravitySounds;
  private final Audio gameOver;
  private final Audio endSound;
  private final PanelInterface panel;
  private final EndGame end;
  private boolean game = true;

  public GamePlay(Map maker, PanelInterface panel, EndGame end,
      Audio endSound) {
    this.maker = maker;
    this.panel = panel;
    this.end = end;
    this.endSound = endSound;
    this.gravity = new Gravity();
    this.gravitySounds = new Audio();
    this.gameOver = new Audio();
  }

  public void game() throws InterruptedException {
    while (this.game) {
      Thread.sleep(250);
      this.maker.setMoved(this.maker.getSprites());
      this.gravity.BrickCoinSlide(this.maker.getSprites());
      this.gravity.BrickCoinFall(this.maker.getSprites(), this.gravitySounds,
          this.panel);
      if (this.gravity.isGameOver()) {
        this.endSound.Sound();
        this.end.gameOver(this.gameOver);
        this.game = false;
      }
      this.panel.update();
    }
  }
}
