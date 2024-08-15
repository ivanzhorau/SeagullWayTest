package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private static final By signUpButton = By.cssSelector("#newAccountBox a.gr-button:nth-child(3)");
    private static final By signInButton = By.cssSelector("#signIn a:nth-child(1)");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUp() {
        getDriver().findElement(signUpButton).click();
    }

    public void clickSignIn() {
        getDriver().findElement(signInButton).click();
    }

}
