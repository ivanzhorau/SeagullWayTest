package by.goodreads.steps;

import by.goodreads.User;
import by.goodreads.pages.SelectSignInTypePage;
import by.goodreads.pages.SignInByEmailPage;
import by.goodreads.pages.StartPage;
import org.openqa.selenium.WebDriver;

public class LoginStep extends Step {
    private final WebDriver driver;
    private final User user;

    public LoginStep(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
    }

    @Override
    public void run() {
        StartPage home = new StartPage(driver);
        home.clickSignIn();
        new SelectSignInTypePage(driver).clickSignInByEmail();
        SignInByEmailPage signInPage = new SignInByEmailPage(driver);
        signInPage.enterEmail(user.getEmail());
        signInPage.enterPassword(user.getPassword());
        signInPage.clickSignIn();
    }
}
