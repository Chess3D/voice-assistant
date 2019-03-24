package assistant.module;

import assistant.template.Module;

public class Calendar extends Module {

    // A String array holding the modifiers to runModule
    private String[] modifierStrings;

    public void runModule(String input) {
        modifierStrings = parseInput(input);

        

        response();
    }

    public String[] parseInput(String input) {
        
        return null;
    }

    public void response() {
        System.out.println("Response called for Calendar");
    }
}