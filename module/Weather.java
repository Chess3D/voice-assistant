package zer0.module;

import zer0.template.Module;

public class Weather extends Module {

    // A String array holding the modifiers to runModule
    private String[] modifierStrings;

    //
    private boolean responseCalled;

    public void runModule(String input) {
        responseCalled = false;

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
        responseCalled = true;
        System.out.println("Response called for Weather");
    }

    public boolean getResponseCalled() {
        return responseCalled;
    }
}