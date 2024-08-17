package by.goodreads.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RateComponent extends BasicComponent{
    private static final By star = By.cssSelector("a");
    public RateComponent(WebElement parentElement) {
        super(parentElement);
    }

    public void setRate(int rate){
        getParentElement().findElements(star).get(rate-1).click();
    }
}
