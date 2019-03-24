package assistant.utility;

import assistant.module.*;

public class ModuleRegistration {

    // An object reference of ModuleProcessor create so registerModule can be called
    private ModuleProcessor moduleProcessor;

    // List of desired modules
    private Calendar calendar = new Calendar();
    private Weather weather = new Weather();
    private Time time = new Time();

    /**
     * Points moduleProcessor to the given moduleProcessor object reference
     */
    public ModuleRegistration(ModuleProcessor moduleProcessor) {
        this.moduleProcessor = moduleProcessor;
    }

    /**
     * Registers the desired modules using the module's object reference and keyword
     */
    public void registerModules() {
        moduleProcessor.registerModule(calendar, "calendar");
        moduleProcessor.registerModule(weather, "weather");
        moduleProcessor.registerModule(time, "time");
    }
}