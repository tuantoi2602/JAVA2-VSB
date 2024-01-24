package GUI.Interface;

import java.awt.Graphics;

public interface PanelInterface {

  public void paintComponent(Graphics g);

  public void update();

  public int getCoinsGet();

  public void setCoinsGet(int CoinsGet);

  public int getScore();

  public void setScore(int score);
}
