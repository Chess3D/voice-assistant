package assistant.template;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class SpeechToText {
    Configuration configuration;
    LiveSpeechRecognizer recognizer;

    public SpeechToText() {
        Configuration configuration = new Configuration();

        // Set path to acoustic model
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
      
        // Set path to dictionary
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

        // Set language model
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

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
        return recognizer.getResult().getHypothesis();
    }
}