package GUI.Element;

import java.awt.Image;

import GUI.SpriteType;
import GUI.Interface.SpriteInterface;
import LauchMap.Status;

public abstract class Sprite implements SpriteInterface {
  protected Image image;
  protected int x = 0, y = 0;
  protected Status status;
  protected SpriteType type;
  protected boolean hasMoved = false;
  protected boolean blocked = false;
  protected boolean isNearPlayer = false;
  protected boolean hasAbovePlayer = false;
  private int direction = 0;

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public Image getImage() {
    return this.image;
  }

  @Override
  public void setImage(Image image) {
    this.image = image;
  }

  @Override
  public Status getStatus() {
    return this.status;
  }

  @Override
  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public SpriteType getType() {
    return this.type;
  }

  @Override
  public boolean HasMoved() {
    return this.hasMoved;
  }

  @Override
  public void setHasMoved(boolean hasMoved) {
    this.hasMoved = hasMoved;
  }

  @Override
  public int getDirection() {
    return this.direction;
  }

  @Override
  public void setDirection(int direction) {
    this.direction = direction;
  }

  @Override
  public boolean HasAbovePlayer() {
    return this.hasAbovePlayer;
  }

  @Override
  public void sethasAbovePlayer(boolean hasAbovePlayer) {
    this.hasAbovePlayer = hasAbovePlayer;
  }

  @Override
  public boolean isBlocked() {
    return this.blocked;
  }

  @Override
  public void setBlocked(boolean blocked) {
    this.blocked = blocked;
  }
}
