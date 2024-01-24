package ControlInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import ControlInput.ControlInputInterface.ControlInterface;
import ControlInput.ControlInputInterface.KeyboardInterface;
import LauchMap.PlayerMove;

@SuppressWarnings("deprecation")
public class Keyboard extends Observable
    implements KeyListener, KeyboardInterface {
  private ControlInterface controller;

  public PlayerMove Key(final int keyCode) {
    PlayerMove key = null;
    switch (keyCode) {
      case KeyEvent.VK_D:
        key = PlayerMove.RIGHT;
        break;
      case KeyEvent.VK_A:
        key = PlayerMove.LEFT;
        break;
      case KeyEvent.VK_W:
        key = PlayerMove.UP;
        break;
      case KeyEvent.VK_S:
        key = PlayerMove.DOWN;
        break;
    }
    return key;
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    this.getController().setControl(Key(keyEvent.getKeyCode()));
    extracted();
    extracted(keyEvent);
  }

  private void extracted() {
    setChanged();
  }

  private void extracted(KeyEvent keyEvent) {
    notifyObservers(keyEvent);
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  public ControlInterface getController() {
    return this.controller;
  }

  public void setController(ControlInterface controller) {
    this.controller = controller;
  }

  @Override
  public PlayerMove Player(int keyCode) {
    return null;
  }
}
