package by.goodreads.steps.actions;

import by.goodreads.steps.Step;
import org.openqa.selenium.WebDriver;

public class GoToUrlStep extends Step {
    private final WebDriver driver;
    private final String url;
    public GoToUrlStep(WebDriver driver, String url){
        this.driver = driver;
        this.url = url;
    }
    @Override
    public void run() {
        driver.get(url);
    }
}
