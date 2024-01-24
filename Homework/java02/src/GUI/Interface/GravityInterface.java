package GUI.Interface;

public interface GravityInterface {

  public SpriteInterface[][] BrickCoinFall(SpriteInterface[][] sprites,
      AudioInterface audio, PanelInterface panel);

  public Boolean SpriteBackground(SpriteInterface sprites);

  public SpriteInterface[][] BrickCoinSlide(SpriteInterface[][] sprites);

  public boolean isGameOver();
}
