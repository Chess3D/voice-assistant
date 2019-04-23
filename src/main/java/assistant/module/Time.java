package assistant.module;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import assistant.template.Module;

public class Time extends Module {

    // The current time
    private String time;

    /**
     * Sets time to the current time and calls response
     */
    public void runModule(String input) {
        time = "" + LocalDateTime.now();

        response();
    }

    /**
     * There are no input modifiers that must be processed for this command
     */
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

        JOptionPane.showMessageDialog(null, "It's " + hour + ":" + minute + " " + meridiem, "What's the Time?", 1);
    }
}