package by.goodreads.scripts;

import by.goodreads.steps.Step;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Script {
    private List<Step> steps;
    private boolean skip = false;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public void execute() {
        logger.log(Level.INFO, String.format("Script: '%s' started%n", getSummary()));
        for (Step step : steps) {
            if (skip && step.getRole() != Step.Role.CLEANUP) {
                step.skip();
                continue;
            }
            try {
                step.execute();
            } catch (Throwable e) {
                logger.log(Level.WARNING, e.toString());
                logger.log(Level.INFO, String.format("Script: '%s' failed on step: %s%n", getSummary(), step.getSummary()));
                skip = true;
            }
        }
        logger.log(Level.INFO, String.format("Script: '%s' finished %n", getSummary()));
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getSummary() {
        return this.getClass().getName();
    }
}
