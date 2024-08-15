package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectSignInTypePage extends Page {
    private static final By signInByEmailButton = By.cssSelector(".third_party_sign_in > a:nth-child(4) > button");

    public SelectSignInTypePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInByEmail() {
        getDriver().findElement(signInByEmailButton).click();
    }
}
