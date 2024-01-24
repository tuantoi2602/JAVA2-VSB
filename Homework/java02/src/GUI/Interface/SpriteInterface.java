package GUI.Interface;

import java.awt.Image;

import GUI.SpriteType;
import LauchMap.Status;

public interface SpriteInterface {

  public int getX();

  public void setX(int x);

  public int getY();

  public void setY(int y);

  public Image getImage();

  public void setImage(Image image);

  public Status getStatus();

  public void setStatus(Status status);

  public SpriteType getType();

  public boolean HasMoved();

  public void setHasMoved(boolean hasMoved);

  public int getDirection();

  public void setDirection(int direction);

  public boolean HasAbovePlayer();

  public boolean isBlocked();

  public void setBlocked(boolean blocked);

  void sethasAbovePlayer(boolean hasAbovePlayer);
}
