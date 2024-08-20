package by.goodreads.steps.actions;

import by.goodreads.User;
import by.goodreads.pages.BasicHomePage;
import by.goodreads.steps.Step;

public class LogoutStep extends Step {
    private final User user;

    public LogoutStep(User user) {
        this.user = user;
        setRole(Role.CLEANUP);
    }

    @Override
    public void run() {
        BasicHomePage homePage = new BasicHomePage(user.getDriver());
        homePage.clickProfileMenu();
        homePage.clickSignOut();
    }
}
