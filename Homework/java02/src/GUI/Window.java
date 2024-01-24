package GUI;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import ControlInput.ControlInputInterface.KeyboardInterface;
import GUI.Interface.PanelInterface;
import GUI.Interface.WindowInterface;

@SuppressWarnings("serial")
public class Window extends JFrame implements WindowInterface {
  private Panel panel;
  private ScorePanel scorePanel;
  int finalCoins;

  public Window(Map map, KeyboardInterface keyboard, int title) {

    this.setTitle("Boulder Dash type Mario Bros - level " + title);
    this.setSize(660, 420);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setFocusable(true);
    this.addKeyListener((KeyListener) keyboard);

    this.panel = new Panel(map, this.finalCoins);
    this.setContentPane(this.panel);
    this.setVisible(true);

  }

  public Window(String playerName) {
    this.setTitle("Score");
    this.setSize(660, 420);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setFocusable(true);

    this.scorePanel = new ScorePanel(playerName);
    this.setContentPane(this.scorePanel);
    this.setVisible(true);
  }

  @Override
  public PanelInterface getPanel() {
    return this.panel;
  }
}
