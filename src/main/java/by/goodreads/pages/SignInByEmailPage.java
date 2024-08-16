package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInByEmailPage extends Page{
    private static final By emailInput = By.cssSelector("#ap_email");
    private static final By passwordInput = By.cssSelector("#ap_password");
    private static final By signInButton = By.cssSelector("#signInSubmit");

    public SignInByEmailPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email){
        getDriver().findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password){
        getDriver().findElement(passwordInput).sendKeys(password);
    }

    public void clickSignIn(){
        getDriver().findElement(signInButton).click();
    }
}
