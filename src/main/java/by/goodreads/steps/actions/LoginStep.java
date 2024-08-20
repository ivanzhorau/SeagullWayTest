package by.goodreads.steps.actions;

import by.goodreads.User;
import by.goodreads.pages.SelectSignInTypePage;
import by.goodreads.pages.SignInByEmailPage;
import by.goodreads.pages.StartPage;
import by.goodreads.steps.Step;
import org.openqa.selenium.WebDriver;

public class LoginStep extends Step {
    private final User user;

    public LoginStep(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        WebDriver driver = user.getDriver();
        StartPage home = new StartPage(driver);
        home.clickSignIn();
        new SelectSignInTypePage(driver).clickSignInByEmail();
        SignInByEmailPage signInPage = new SignInByEmailPage(driver);
        signInPage.enterEmail(user.getEmail());
        signInPage.enterPassword(user.getPassword());
        signInPage.clickSignIn();
    }
}
