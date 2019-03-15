package zer0;

import zer0.utility.ModuleProcessor;
import zer0.utility.ModuleRegistration;

public class zer0 {

    public static void main(String[] args) {

        // Initializes moduleProcessor
        ModuleProcessor moduleProcessor = new ModuleProcessor();

        // Initializes moduleRegistration
        ModuleRegistration moduleRegistration = new ModuleRegistration(moduleProcessor);

        // Registers the modules found in ModuleRegistration
        moduleRegistration.registerModules();

        // Name of the voice assistant
        String name = "WIP";

        // Phrase required for the voice assistant to preform an action
        String keyPhrase = "Hey " + name;

        // Holds the voice input received by the voice assistant
        String input;

        // Prevents the program from stopping
        while(true) {

            // Resets the input to an empty string
            input = "";

            // Continues to update input until the key phrase is spoken
            while(input.toLowerCase().indexOf(keyPhrase.toLowerCase()) == -1) {
                // input = "Hey Zer0, what is on my calendar?";
            }

            // Cuts off everything spoken before the key phrase 
            input = input.toLowerCase().substring(input.toLowerCase().lastIndexOf(keyPhrase.toLowerCase()));

            // Attempts to call a module using the given input
            moduleProcessor.callModule(input);
        }
    }
}