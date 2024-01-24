package GUI.Interface;

import java.awt.Graphics;

public interface MapInterface {

  public void createElement(final int size);

  public void drawMap(Graphics g);

  public SpriteInterface[][] getSprites();

  public SpriteInterface getPlayer(int col, int row);

  public void setSprites(SpriteInterface[][] sprites);

  public void setMoved(SpriteInterface[][] sprites);
}
