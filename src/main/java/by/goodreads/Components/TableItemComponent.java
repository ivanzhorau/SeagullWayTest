package by.goodreads.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableItemComponent extends BasicComponent {
    private static final By wantToReadButton = By.cssSelector("button.wtrToRead");
    private static final By readButton = By.cssSelector(".wtrExclusiveShelves li[data-shelf-name='read'] button");
    private static final By openShelfButton = By.cssSelector("button.wtrShelfButton");

    public TableItemComponent(WebElement parentElement) {
        super(parentElement);
    }

    public void clickWantToRead(){
        getParentElement().findElement(wantToReadButton).click();
    }

    public void markAsRead(){
        getParentElement().findElement(openShelfButton).click();
        getParentElement().findElement(readButton).click();
    }
}
