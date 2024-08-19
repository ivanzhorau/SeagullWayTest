package by.goodreads.scripts;

import by.goodreads.steps.Step;

import java.util.List;

public class Script {
    private List<Step> steps;

    public void execute() throws Throwable {
        System.out.printf("Script: '%s' started%n", getSummary());
        for (Step step : steps) {
            try {
                step.execute();
            }catch (Throwable e){
                e.printStackTrace();
                System.out.printf("Script: '%s' failed on step: %s%n", getSummary(), step.getSummary());
                return;
            }
        }
        System.out.printf("Script: '%s' finished %n", getSummary());
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getSummary(){
        return this.getClass().getName();
    }
}
