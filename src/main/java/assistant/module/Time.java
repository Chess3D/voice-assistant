package assistant.module;

import java.time.LocalDateTime;

import assistant.template.Module;

public class Time extends Module {

    // A String array holding the modifiers to runModule
    private String[] modifierStrings;

    // The current time
    private String time;

    /**
     * Sets time to the current time and calls response
     */
    public void runModule(String input) {
        modifierStrings = parseInput(input);

        time = "" + LocalDateTime.now();

        response();
    }

    public String[] parseInput(String input) {
        return null;
    }

    /**
     * Converts the current time into an output
     */
    public void response() {
        int hour = Integer.parseInt(time.substring(time.indexOf("T") + 1, time.indexOf(":")));
        String minute = time.substring(time.indexOf(":") + 1, time.lastIndexOf(":"));
        String meridiem;

        if(hour > 12) {
            hour -= 12;
            meridiem = "PM";
        } else {
            meridiem = "AM";
        }

        System.out.println("It is " + hour + ":" + minute + " " + meridiem + ".");
    }
}