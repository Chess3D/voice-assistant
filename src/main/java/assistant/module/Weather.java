package assistant.module;

import assistant.template.Module;

public class Weather extends Module {

    // A String array holding the modifiers to runModule
    private String[] modifierStrings;

    public void runModule(String input) {
        modifierStrings = parseInput(input);

        response();
    }

    /**
     * Modifiers
     * 0:Time
     * 1:State/Country
     * 2:City
     */
    public String[] parseInput(String input) {
        String[] modifiers = new String[3];

        return modifiers;
    }

    public void response() {
        System.out.println("Response called for Weather");
    }
}