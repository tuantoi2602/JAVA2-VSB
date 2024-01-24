package ControlInput;

import java.io.File;

import javax.swing.JOptionPane;

import GUI.Audio;
import GUI.Window;
import GUI.Interface.PanelInterface;

public class EndGame {
  private final PanelInterface panel;
  private final Window window;

  public EndGame(PanelInterface panel, Window window) {
    this.panel = panel;
    this.window = window;
  }

  public void gameOver(Audio audio) {
    this.panel.update();
    JOptionPane.showMessageDialog(null, "Game Over!");
    this.window.dispose();
  }

  public void victory(Audio audio) {
    audio.Sound(new File("music/victory.wav"), 10.0f);
    this.panel.update();
    JOptionPane.showMessageDialog(null, "Victory!");
    this.window.dispose();
  }
}
