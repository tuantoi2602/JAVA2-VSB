package GUI;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import GUI.Interface.AudioInterface;

public class Audio implements AudioInterface {
  private Clip clip;

  @Override
  public void Sound(File sound, float gain) {
    try {
      this.clip = AudioSystem.getClip();
      this.clip.open(AudioSystem.getAudioInputStream(sound));
      this.clip.start();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    }

  }

  public void Sound() {
    this.clip.stop();
  }

}
