package GUI;

import java.awt.Graphics;

import GUI.Element.Background;
import GUI.Element.Block;
import GUI.Element.Brick;
import GUI.Element.Coin;
import GUI.Element.Dirt;
import GUI.Element.Gate;
import GUI.Element.Player;
import GUI.Element.Sprite;
import GUI.Interface.MapInterface;
import GUI.Interface.SpriteInterface;

public class Map implements MapInterface {
  private SpriteInterface[][] sprites = new Sprite[22][40];
  private final SpriteType map[][];
  private int x = 0, y = 0, row = 0, col = 0;

  public Map(TranslateMap translate) {
    this.map = translate.getMap();
  }

  @Override
  public void createElement(final int size) {
    this.row = 0;
    for (SpriteType[] unSpriteTp : this.map) {
      this.x = 0;
      this.col = 0;
      for (SpriteType SpriteTp : unSpriteTp) {
        switch (SpriteTp) {
          case BLOCK:
            this.sprites[this.row][this.col] = new Block(this.x, this.y);
            break;
          case DIRT:
            this.sprites[this.row][this.col] = new Dirt(this.x, this.y);
            break;
          case BACKGROUND:
            this.sprites[this.row][this.col] = new Background(this.x, this.y);
            break;
          case BRICK:
            this.sprites[this.row][this.col] = new Brick(this.x, this.y);
            break;
          case COIN:
            this.sprites[this.row][this.col] = new Coin(this.x, this.y);
            break;
          case PLAYER:
            this.sprites[this.row][this.col] = new Player(this.x, this.y);
            break;
          case GATE:
            this.sprites[this.row][this.col] = new Gate(this.x, this.y);
            break;
        }
        this.x = this.x + size;
        this.col++;
      }
      this.y = this.y + size;
      this.row++;
    }
  }

  @Override
  public void drawMap(Graphics g) {
    for (SpriteInterface[] unSprite : this.sprites) {
      for (SpriteInterface Sprite : unSprite) {
        g.drawImage(Sprite.getImage(), Sprite.getX(), Sprite.getY(), null);
      }
    }
  }

  @Override
  public SpriteInterface[][] getSprites() {
    return this.sprites;
  }

  @Override
  public SpriteInterface getPlayer(int col, int row) {
    return this.sprites[row][col];
  }

  @Override
  public void setSprites(SpriteInterface[][] sprites) {
    this.sprites = sprites;
  }

  @Override
  public void setMoved(SpriteInterface[][] sprites) {
    for (SpriteInterface[] unSprite : sprites) {
      for (SpriteInterface Sprite : unSprite) {
        Sprite.setHasMoved(false);
      }
    }
  }
}
