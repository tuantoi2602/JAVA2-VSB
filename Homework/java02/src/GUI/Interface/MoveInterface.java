package GUI.Interface;

public interface MoveInterface {
  public SpriteInterface[][] digLeft(int col, int row, SpriteInterface sprite,
      AudioInterface audio);

  public SpriteInterface[][] digRight(int col, int row, SpriteInterface sprite,
      AudioInterface audio);

  public SpriteInterface[][] digUp(int col, int row, SpriteInterface sprite,
      AudioInterface audio);

  public SpriteInterface[][] digDown(int col, int row, SpriteInterface sprite,
      AudioInterface audio);

  public void gameOver(boolean gameOver);

  public boolean isGameOver();

  public boolean isVictory();

  public void setVictory(boolean victory);

  public Boolean nextBackground(SpriteInterface sprite);

}
