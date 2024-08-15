package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
    private static By signInButton = By.cssSelector("#newAccountBox a.gr-button:nth-child(3)");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn(){
         getDriver().findElement(signInButton).click();
    }
}
