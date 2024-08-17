package by.goodreads.pages;

import by.goodreads.components.TableItemComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchPage extends BasicHomePage {
    private static final By tableItem = By.cssSelector(".tableList > tbody > tr");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<TableItemComponent> getTableItems() {
        return getDriver().findElements(tableItem).stream().map(TableItemComponent::new).toList();
    }
}
