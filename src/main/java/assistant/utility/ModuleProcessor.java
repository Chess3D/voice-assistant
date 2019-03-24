package assistant.utility;

import assistant.template.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModuleProcessor {

    // A HashMap storing all keywords and associated module classes
    private HashMap<String, Module> registeredModules = new HashMap<String, Module>(0);

    // An ArrayList storing the keywords of every registered module
    private ArrayList<String> keywords = new ArrayList<String>(0);

    // An executer that dynamically adds and reuses threads as necessary
    private ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * Adds a module and its keyword to the registeredModules HashMap
     * and adds the module keyword to the keywords ArrayList
     */
    public void registerModule(Module module, String keyword) {

        // Adds the module and its keyword to the HashMap
        registeredModules.put(keyword, module);

        // Adds the keyword of the module to the ArrayList
        keywords.add(keyword);
    }

    /**
     * Searches through the input, calling a module if the input contains its keyword,
     * and stops searching once a valid module is found
     */
    public boolean callModule(String input) {
        
        // Cycles through every module's keyword
        for(String key : keywords) {

            // Checks if a module's key word is in the input
            if(input.toLowerCase().indexOf(key.toLowerCase()) != -1) {
                
                // Completes run module in its own thread, allowing multiple modules to run at once
                executor.submit(() -> {
                    registeredModules.get(key).runModule(input);
                });

                // Exits the class to prevent multiple calls for the same input
                return true;
            }
        }

        return false;
    }
}