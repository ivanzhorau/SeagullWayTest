package by.goodreads.scripts;

import by.goodreads.steps.Step;

import java.util.List;

public class Script {
    private List<Step> steps;

    public void execute() throws Throwable {
        for (Step step : steps) {
            step.execute();
        }
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
