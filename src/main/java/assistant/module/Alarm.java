package assistant.module;

import javax.swing.JOptionPane;

import assistant.template.Module;

public class Alarm extends Module {

    public void runModule(String input) {

        // The system time of when the command was called
        long startTime = System.nanoTime();

        // Wait for five minuets
        while(System.nanoTime() - startTime < 60e9 * 5) {}

        // Call response after wait period has expired
        response();
    }

    public String[] parseInput(String input) {
        return null;
    }

    public void response() {
        JOptionPane.showMessageDialog(null, "BEEP BOOP! Your alarm is going off", "Alarm", 2);
    }
}