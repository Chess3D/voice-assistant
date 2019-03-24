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

        // C
        SpeechToText speechToText = new SpeechToText();

        // Name of the voice assistant
        String name = "Q";

        // Phrase required for the voice assistant to preform an action
        String keyPhrase = name;

        // Holds the voice input received by the voice assistant
        String input;

        // Starts speech recognition
        speechToText.startRecognition();

        // Prevents the program from stopping
        while(true) {

            // Resets the input to an empty string
            input = "";

            // Continues to update input until the key phrase is spoken
            while(input.toLowerCase().indexOf(keyPhrase.toLowerCase()) == -1) {
                input = speechToText.getResults();
                System.out.println(input);
            }

            // Cuts off everything spoken before the key phrase 
            input = input.toLowerCase().substring(input.toLowerCase().lastIndexOf(keyPhrase.toLowerCase()));

            // Attempts to call a module until a module is called
            while(!moduleProcessor.callModule(input)) {
                input = speechToText.getResults();
                System.out.println(input);
            }
        }
    }
}