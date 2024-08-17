package by.goodreads.steps;

import by.goodreads.User;
import by.goodreads.pages.BasicHomePage;

public class LogoutStep extends Step {
    private final User user;

    public LogoutStep(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        BasicHomePage homePage = new BasicHomePage(user.getDriver());
        homePage.clickProfileMenu();
        homePage.clickSignOut();
    }
}
