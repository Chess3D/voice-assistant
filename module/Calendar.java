package zer0.module;

import zer0.template.Module;

public class Calendar extends Module {

    // A String array holding the modifiers to runModule
    String[] modifierStrings;

    public void runModule(String input) {
        modifierStrings = parseInput(input);

        

        response();
    }

    public String[] parseInput(String input) {
        
        return null;
    }

    public void response() {
        System.out.println("runModule called for Calendar");
    }
}