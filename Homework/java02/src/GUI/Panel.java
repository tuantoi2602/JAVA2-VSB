package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import GUI.Interface.MapInterface;
import GUI.Interface.PanelInterface;

@SuppressWarnings("serial")
public class Panel extends JPanel implements PanelInterface {
  protected Image[][] buffer = new Image[22][40];
  Font panelFont = new Font("Time New Roman", Font.BOLD, 15);
  private int CoinsGet = 0, score = 0;
  private final MapInterface map;

  public Panel(Map map, int finalCoins) {
    this.map = map;
  }

  public void totalCoin(Graphics g) {
    g.setFont(this.panelFont);
    g.setColor(Color.black);
    g.drawString("Coins : " + this.CoinsGet, 10, 365);
  }

  public void totalScore(Graphics g) {
    g.setFont(this.panelFont);
    g.setColor(Color.black);
    g.drawString("Score : " + this.score, 10, 380);
  }

  public void updateCS(Graphics g) {
    g.setColor(Color.white);
    g.fillRect(0, 0, 800, 500);
  }

  @Override
  public void paintComponent(Graphics g) {
    this.updateCS(g);
    this.totalCoin(g);
    this.totalScore(g);
    this.map.drawMap(g);
  }

  @Override
  public void update() {
    this.repaint();
  }

  @Override
  public int getCoinsGet() {
    return this.CoinsGet;
  }

  @Override
  public void setCoinsGet(int CoinsGet) {
    this.CoinsGet = CoinsGet;
  }

  @Override
  public int getScore() {
    return this.score;
  }

  @Override
  public void setScore(int score) {
    this.score = score;
  }
}
