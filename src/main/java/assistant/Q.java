package assistant;

import assistant.template.SpeechToText;
import assistant.utility.ModuleProcessor;
import assistant.utility.ModuleRegistration;

public class Q {

    public static void main(String[] args) {

        // Initializes moduleProcessor
        ModuleProcessor moduleProcessor = new ModuleProcessor();

        // Initializes moduleRegistration
        ModuleRegistration moduleRegistration = new ModuleRegistration(moduleProcessor);

        // Registers the modules found in ModuleRegistration
        moduleRegistration.registerModules();

        // Implements the SpeechToText class
        SpeechToText speechToText = new SpeechToText();

        // Name of the voice assistant
        String name = "Q";

        // Phrase required for the voice assistant to preform an action
        String keyPhrase = "Hey " + name;

        // Holds the voice input received by the voice assistant
        String input;

        // Starts speech recognition
        speechToText.startRecognition();

        // Prevents the program from stopping
        while(true) {

            // Resets the input to an empty string
            input = "";

            // Continues to update input until the key phrase is spoken
            while(input.indexOf(keyPhrase.toLowerCase()) == -1) {
                input = speechToText.getResults();
                System.out.println(input);
            }

            // Cuts off everything spoken before the key phrase 
            input = input.substring(input.lastIndexOf(keyPhrase.toLowerCase()));

            // The time the key phrase was spoken
            long startTime = System.nanoTime();

            // Attempts to call a module with the given input
            while(!moduleProcessor.callModule(input) && System.nanoTime() - startTime < 10e9) {

                // Appends inputs given within 10 seconds of the key phrase being spoken to the input
                input += speechToText.getResults();
            }
        }
    }
}