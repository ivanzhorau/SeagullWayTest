package by.goodreads.steps.checks;

import by.goodreads.User;
import by.goodreads.pages.BasicHomePage;
import by.goodreads.steps.Step;
import dev.failsafe.internal.util.Assert;

public class CheckUserIsLoggedIn extends Step {
    private final User user;

    public CheckUserIsLoggedIn(User user){
        this.user = user;
        setRole(Role.CHECK);
    }
    @Override
    public void run() throws Throwable {
        BasicHomePage homePage = new BasicHomePage(user.getDriver());
        homePage.clickProfileMenu();
        String userName = homePage.getUserName();
        Assert.isTrue(userName.equals(user.getName().toUpperCase()), String.format("User names (%s and %s) are different", userName, user.getName()));
    }
}
