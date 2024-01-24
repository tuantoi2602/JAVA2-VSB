package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
  protected Image[][] buffer = new Image[22][40];
  Font panelFont = new Font("Time New Roman", Font.BOLD, 15);
  private String str = "";

  public ScorePanel(String str) {
    this.str = str;
  }

  @Override
  public void paintComponent(Graphics g) {
    g.setFont(this.panelFont);
    g.setColor(Color.black);
    g.drawString(this.str, 10, 30);
  }

  public void update() {
    this.repaint();
  }
}
