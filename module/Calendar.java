package zer0.module;

import zer0.template.Module;

public class Calendar extends Module {

    // A String array holding the modifiers to runModule
    private String[] modifierStrings;

    // 
    private boolean responseCalled;

    public void runModule(String input) {
        responseCalled = false;

        modifierStrings = parseInput(input);

        

        response();
    }

    public String[] parseInput(String input) {
        
        return null;
    }

    public void response() {
        responseCalled = true;
        System.out.println("Response called for Calendar");
    }

    public boolean getResponseCalled() {
        return responseCalled;
    }
}