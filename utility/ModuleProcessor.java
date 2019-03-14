package zer0.utility;

import zer0.template.Module;

import java.util.ArrayList;
import java.util.HashMap;

public class ModuleProcessor {

    /**
     * A HashMap storing all keywords and associated module classes
     */
    private HashMap<String, Module> registeredModules = new HashMap<String, Module>(0);

    /**
     * An ArrayList storing the keywords of every registered module
     */
    private ArrayList<String> keywords = new ArrayList<String>(0);

    /**
     * Adds a module and its keyword to the registeredModules HashMap
     * and adds the module keyword to the keywords ArrayList
     */
    public void registerModule(Module module, String keyword) {
        registeredModules.put(keyword, module);
        keywords.add(keyword);
        System.out.println("Keyword: " + keyword + "\nClass: " + module.getClass().getName() + "\n");
    }

    /**
     * Searches through the input, calling a module if the input contains its keyword,
     * and stops searching once a valid module is found
     */
    public void callModule(String input) {
        for(String key : keywords) {
            if(input.toLowerCase().indexOf(key) != -1) {
                System.out.println("Found call to " + key + " module");
                registeredModules.get(key).runModule(input);
                return;
            }
        }
        System.out.println("No module call found");
    }
}