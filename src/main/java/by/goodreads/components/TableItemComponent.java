package by.goodreads.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class TableItemComponent extends BasicComponent {
    private static final By wantToReadButton = By.cssSelector("button.wtrToRead");
    private static final By readButton = By.cssSelector(".wtrExclusiveShelves li[data-shelf-name='read'] button");
    private static final By openShelfButton = By.cssSelector("button.wtrShelfButton");
    private static final By readStatusText = By.cssSelector("div.wtrButtonContainer div[class*='wtrStatus'] > span");


    public TableItemComponent(WebElement parentElement) {
        super(parentElement);
    }

    public void clickWantToRead() {
        getParentElement().findElement(wantToReadButton).click();
    }

    public void markAsRead() {
        getParentElement().findElement(openShelfButton).click();
        getParentElement().findElement(readButton).click();
    }

    public String getReadStatus() {
        new FluentWait<>(getParentElement()).withTimeout(Duration.ofSeconds(5)).until(webElement -> !webElement.findElements(readStatusText).isEmpty());
        return getParentElement().findElement(readStatusText).getText();
    }
}
