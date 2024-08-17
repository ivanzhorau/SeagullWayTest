package by.goodreads.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WindowBoxComponent extends BasicComponent {
    private static final By rateComponent = By.cssSelector(".stars");
    private static final By startReadingDateComponent = By.cssSelector(".startedAtDatePickers");
    private static final By endReadingDateComponent = By.cssSelector(".endedAtDatePickers");
    private static final By postButton = By.cssSelector("input[id *= 'review_submit']");

    public WindowBoxComponent(WebElement parentElement) {
        super(parentElement);
    }

    public RateComponent getRateComponent() {
        return new RateComponent(getParentElement().findElement(rateComponent));
    }

    public DatePickerComponent getStartReadingDateComponent() {
        return new DatePickerComponent(getParentElement().findElement(startReadingDateComponent));
    }

    public DatePickerComponent getEndReadingDateComponent() {
        return new DatePickerComponent(getParentElement().findElement(endReadingDateComponent));
    }

    public void waitForLoad() {
        new FluentWait<>(getParentElement()).withTimeout(Duration.ofSeconds(5)).until(webElement -> !webElement.findElements(By.cssSelector(".bookTitle")).isEmpty());
    }

    public void waitForClose() {
        new FluentWait<>(getParentElement()).withTimeout(Duration.ofSeconds(5)).until(webElement -> !webElement.isDisplayed());
    }

    public void clickPost() {
        getParentElement().findElement(postButton).click();
    }
}
