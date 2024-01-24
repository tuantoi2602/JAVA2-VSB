package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import GUI.Interface.LevelObservator;
import GUI.Interface.MenuInterface;

@SuppressWarnings("serial")
public class Menu extends JFrame implements MenuInterface {

  private Font menuFont = new Font("Time New Roman", Font.BOLD, 15);
  private int level = 0;
  private final String menu = "";
  private final MenuPanel menuPanel;

  private final Image image;
  private List<LevelObservator> observators = new ArrayList<>();

  public Menu() throws IOException {

    setSize(new Dimension(810, 540));
    setResizable(false);
    setLayout(new BorderLayout());
    setFocusable(true);

    this.image = ImageIO.read(new File("image/logo.png"));

    this.menuPanel = new MenuPanel(this);

    JButton button = new JButton("Start - Choose your level want to play");
    button.setHorizontalTextPosition(SwingConstants.RIGHT);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        String name = JOptionPane.showInputDialog(null, "Write your level!\n"
            + "You can choose 'Level 1', 'Level 2','Level 3'");
        switch (name) {
          case "Level 1":
            Menu.this.level = 1;
            break;
          case "Level 2":
            Menu.this.level = 2;
            break;
          case "Level 3":
            Menu.this.level = 3;
            break;
        }
        for (LevelObservator observator : Menu.this.observators) {
          observator.LevelSelected(Menu.this.level, Menu.this.menu);
        }
      }
    });
    this.menuPanel.add(button);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(this.menuPanel);
    this.setVisible(true);
  }

  @Override
  public int getLevel() {
    return 0;
  }

  @Override
  public void drawMenu(Graphics g) {
    g.drawImage(this.image, 0, 0, null);
  }

  @Override
  public List<LevelObservator> getObservators() {
    return this.observators;
  }

  @Override
  public void setObservators(List<LevelObservator> observators) {
    this.observators = observators;
  }

  @Override
  public String getMenu() {
    return null;
  }

  @Override
  public void setMenu(String menu) {
  }

  public Font getMenuFont() {
    return this.menuFont;
  }

  public void setMenuFont(Font menuFont) {
    this.menuFont = menuFont;
  }

}
