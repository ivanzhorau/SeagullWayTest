package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
    private static final By searchBoxInput = By.cssSelector(".searchBox__input--navbar");
    private static final By searchBoxButton = By.cssSelector(".searchBox__icon--navbar");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchBox(String text){
        getDriver().findElement(searchBoxInput).sendKeys(text);
    }

    public void clickSearchButton(){
        getDriver().findElement(searchBoxButton).click();
    }
}
