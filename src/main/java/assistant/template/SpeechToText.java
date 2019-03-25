package assistant.template;

import java.io.IOException;
import java.nio.file.FileSystems;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class SpeechToText {
    Configuration configuration;
    LiveSpeechRecognizer recognizer;

    String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\src\\main\\resources\\";

    public SpeechToText() {


        Configuration configuration = new Configuration();

        // Set path to acoustic model
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
      
        // Set path to dictionary
        configuration.setDictionaryPath("file:" + path + "Pronunciation.dic");

        // Set language model
        configuration.setLanguageModelPath("file:" + path + "Language.lm");

        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startRecognition() {
        recognizer.startRecognition(true);
    }

    public void stopRecognition() {
        recognizer.stopRecognition();
    }

    public String getResults() {
        return recognizer.getResult().getHypothesis().toLowerCase();
    }
}