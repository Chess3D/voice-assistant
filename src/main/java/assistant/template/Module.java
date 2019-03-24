package assistant.template;

public abstract class Module {

    /**
     * Accepts the input to the module and preforms the desired action
     */
    public abstract void runModule(String inputString);

    /**
     * Accepts a string and returns a formated Array
     * @return String array of modifiers that alter the runModule function
     */
	public abstract String[] parseInput(String inputString);

    /**
     * @return The response Q gives when the action is preformed
     */
    public abstract void response();
}