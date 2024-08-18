package by.goodreads.steps;

import by.goodreads.Holder;
import by.goodreads.User;
import by.goodreads.components.TableItemComponent;
import by.goodreads.pages.SearchPage;

import java.util.List;

public class GetTableItemsStep extends Step {
    private final User user;
    private Holder<List<TableItemComponent>> tableItems;
    public GetTableItemsStep(User user, Holder<List<TableItemComponent>> tableItems) {
        this.user = user;
        this.tableItems = tableItems;
    }

    @Override
    public void run() {
        SearchPage searchPage = new SearchPage(user.getDriver());
        tableItems.setValue(searchPage.getTableItems());
    }

}
