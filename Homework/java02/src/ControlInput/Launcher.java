package ControlInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import GUI.Audio;
import GUI.Map;
import GUI.Menu;
import GUI.TranslateMap;
import GUI.Window;
import GUI.Interface.LevelObservator;
import LauchMap.Launch;

public class Launcher implements LevelObservator {
  private final Menu menu;
  private Map map = null;
  static File music = null;
  private static final int SIZE = 16;

  public Launcher() throws IOException {
    this.menu = new Menu();
    this.menu.getObservators().add(this);
  }

  @Override
  public void LevelSelected(int level, String name) {
    new Thread(new Runnable() {
      @SuppressWarnings("deprecation")
      @Override
      public void run() {
        if (level > 3) {
          new Window(Launcher.this.menu.getMenu());
        } else {
          Launch launch = new Launch(level, Launcher.this.menu.getMenu());
          try {
            launch.launch();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          TranslateMap translate;

          try {

            translate = new TranslateMap(launch.getTab());
            Launcher.this.map = new Map(translate);
            Launcher.this.map.createElement(SIZE);

            Keyboard keyboard = new Keyboard();
            Window window = new Window(Launcher.this.map, keyboard, level);

            EndGame end = new EndGame(window.getPanel(), window);
            Audio endSound = new Audio();
            Control controller = new Control(
                Launcher.this.map.getPlayer(translate.getPlayerX(),
                    translate.getPlayerY()),
                window.getPanel(), SIZE, Launcher.this.map, end, endSound);

            keyboard.addObserver(controller);
            keyboard.setController(controller);

            GamePlay game = new GamePlay(Launcher.this.map, window.getPanel(),
                end, endSound);
            game.game();

          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
  }
}
