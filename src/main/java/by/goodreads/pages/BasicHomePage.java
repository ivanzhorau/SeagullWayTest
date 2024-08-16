package by.goodreads.pages;

import by.goodreads.Components.WindowBoxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicHomePage extends Page{
    private static final By searchBoxInput = By.cssSelector(".searchBox__input--navbar");
    private static final By searchBoxButton = By.cssSelector(".searchBox__icon--navbar");
    private static final By windowBox = By.cssSelector("#box");
    public BasicHomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchBox(String text){
        getDriver().findElement(searchBoxInput).sendKeys(text);
    }

    public void clickSearchButton(){
        getDriver().findElement(searchBoxButton).click();
    }

    public WindowBoxComponent getWindowBox(){
        return new WindowBoxComponent(getDriver().findElement(windowBox));
    }
}
