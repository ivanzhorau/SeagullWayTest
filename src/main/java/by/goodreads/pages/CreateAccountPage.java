package by.goodreads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends Page{
    private static final By nameInput = By.cssSelector("#ap_customer_name");
    private static final By emailInput = By.cssSelector("#ap_email");
    private static final By passwordInput = By.cssSelector("#ap_password");
    private static final By passwordCheckInput = By.cssSelector("#ap_password_check");
    private static final By createAccountButton = By.cssSelector("#continue");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name){
        getDriver().findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email){
        getDriver().findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password){
        getDriver().findElement(passwordInput).sendKeys(password);
    }
    public void enterPasswordCheck(String passwordCheck){
        getDriver().findElement(passwordCheckInput).sendKeys(passwordCheck);
    }

    public void createAccountClick(){
        getDriver().findElement(createAccountButton).click();
    }
}
