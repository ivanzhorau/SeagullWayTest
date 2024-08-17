package by.goodreads.steps;

import by.goodreads.User;
import by.goodreads.pages.BasicHomePage;

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
