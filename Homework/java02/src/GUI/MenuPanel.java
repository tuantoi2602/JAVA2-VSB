package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
  protected Image buffer[][] = new Image[22][40];
  private final Menu menu;

  public MenuPanel(Menu menu) {
    this.menu = menu;
  }

  @Override
  public void paintComponent(Graphics g) {

    this.menu.drawMenu(g);
  }
}
