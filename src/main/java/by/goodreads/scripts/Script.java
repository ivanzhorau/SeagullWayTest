package by.goodreads.scripts;

import by.goodreads.steps.Step;

import java.util.List;

public class Script {
    private List<Step> steps;
    private boolean skip = false;

    public void execute() {
        System.out.printf("Script: '%s' started%n", getSummary());
        for (Step step : steps) {
            if (skip && step.getRole() != Step.Role.CLEANUP) {
                step.skip();
                continue;
            }
            try {
                step.execute();
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.printf("Script: '%s' failed on step: %s%n", getSummary(), step.getSummary());
                skip = true;
            }
        }
        System.out.printf("Script: '%s' finished %n", getSummary());
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getSummary() {
        return this.getClass().getName();
    }
}
