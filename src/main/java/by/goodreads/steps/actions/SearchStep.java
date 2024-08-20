package by.goodreads.steps.actions;

import by.goodreads.User;
import by.goodreads.pages.BasicHomePage;
import by.goodreads.steps.Step;

public class SearchStep extends Step {
    private final User user;
    private final String searchQuery;

    public SearchStep(User user, String searchQuery) {
        this.user = user;
        this.searchQuery = searchQuery;
    }

    @Override
    public void run() {
        BasicHomePage homePage = new BasicHomePage(user.getDriver());
        homePage.enterTextToSearchBox(searchQuery);
        homePage.clickSearchButton();
    }
}
