package GUI.Interface;

import java.awt.Graphics;
import java.util.List;

public interface MenuInterface {
  public List<LevelObservator> getObservators();

  public void setObservators(List<LevelObservator> observators);

  public int getLevel();

  public void drawMenu(Graphics g);

  public String getMenu();

  public void setMenu(String menu);
}
