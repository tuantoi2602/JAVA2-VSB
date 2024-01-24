package GUI;

import java.util.HashMap;
import java.util.Map;

import GUI.Interface.TranslateMapInterface;

public class TranslateMap implements TranslateMapInterface {
  private final Map<Character, SpriteType> translator = new HashMap<>();
  private int PlayerX = 0, PlayerY = 0;
  private final SpriteType map[][] = new SpriteType[22][40];

  public TranslateMap(char[][] tab) {

    this.translator.put('#', SpriteType.BLOCK);
    this.translator.put('_', SpriteType.DIRT);
    this.translator.put('Z', SpriteType.BACKGROUND);
    this.translator.put('O', SpriteType.BRICK);
    this.translator.put('C', SpriteType.COIN);
    this.translator.put('G', SpriteType.GATE);
    this.translator.put('P', SpriteType.PLAYER);

    int row = 0, col = 0;
    for (char unTab[] : tab) {
      col = 0;
      for (char ch : unTab) {
        if (this.translator.containsKey(ch)) {
          this.map[row][col] = this.translator.get(ch);
          if (ch == 'P') {
            this.PlayerX = col;
            this.PlayerY = row;
          }
        } else {
          System.out.println("Error");
        }
        col++;
      }
      row++;
    }
  }

  public SpriteType[][] getMap() {
    return this.map;
  }

  @Override
  public int getPlayerX() {
    return this.PlayerX;
  }

  @Override
  public int getPlayerY() {
    return this.PlayerY;
  }
}
