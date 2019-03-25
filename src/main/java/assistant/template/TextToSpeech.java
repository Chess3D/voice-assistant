package assistant.template;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;

public class TextToSpeech {
    LocalMaryInterface maryInterface;
    AudioInputStream audioInputStream;

    public TextToSpeech() {
        try {
            maryInterface = new LocalMaryInterface();
        } catch (MaryConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void say(String input) {
        try {
            audioInputStream = maryInterface.generateAudio(input);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (SynthesisException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            LocalMaryInterface maryInterface = new LocalMaryInterface();

            AudioInputStream audioInputStream = maryInterface.generateAudio("test one two three");
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            System.out.println("Done");
        } catch (SynthesisException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MaryConfigurationException e) {
            e.printStackTrace();
        }
    }
}