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

        // Attempts to call a module using the given input
        moduleProcessor.callModule("What time is it?");
    }
}