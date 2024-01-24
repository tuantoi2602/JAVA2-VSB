package GUI;

import GUI.Element.Coin;
import GUI.Interface.GateInterface;
import GUI.Interface.SpriteInterface;

public class Gate implements GateInterface {
  @Override
  public SpriteInterface[][]
      BrickBackgroundCoin(SpriteInterface[][] sprites, final int size) {
    int row = 0, col = 0, x = 0, y = 0;
    for (SpriteInterface[] sousSprite : sprites) {
      x = 0;
      col = 0;
      for (SpriteInterface Sprite : sousSprite) {
        if (Sprite.getType() != SpriteType.BLOCK
            && Sprite.getType() != SpriteType.PLAYER) {
          sprites[row][col] = new Coin(x, y);
        }
        x = x + size;
        col++;
      }
      y = y + size;
      row++;
    }
    return sprites;
  }
}
