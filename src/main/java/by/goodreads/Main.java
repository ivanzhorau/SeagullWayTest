package by.goodreads;

import by.goodreads.components.TableItemComponent;
import by.goodreads.steps.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        goodReadsFlow(driver);
        cleanup(driver);
        driver.close();
    }

    private static void cleanup(WebDriver driver) {
        driver.get("https://www.goodreads.com/");
        User user01 = User.loadUserFromFile("src/main/resources/users.json", "user1", driver);
        new LoginStep(user01).run();
        driver.findElement(By.cssSelector(".siteHeader__primaryNavInline > ul:nth-child(1) > li:nth-child(2)")).click();
        driver.findElements(By.cssSelector("a.deleteLink")).forEach(webElement -> {
            webElement.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        });
        new LogoutStep(user01).run();
    }

    private static void goodReadsFlow(WebDriver driver) {
        driver.get("https://www.goodreads.com/");
        User user01 = User.loadUserFromFile("src/main/resources/users.json", "user1", driver);
        User user02 = User.loadUserFromFile("src/main/resources/users.json", "user_wrong_password", driver);

        new LoginStep(user02).run();
        driver.get("https://www.goodreads.com/");
        new LoginStep(user01).run();

        new SearchStep(user01, "Best crime and mystery books").run();

        Holder<List<TableItemComponent>> holder = new Holder<>();
        new GetTableItemsStep(user01, holder).run();
        List<TableItemComponent> itemList = holder.getValue();
        for (int i = 0; i < 3; i++) {
            new MarkBookAsWantToReadStep(itemList.get(i)).run();
        }
        for (int i = 0; i < 3; i++) {
            new MarkBookAsReadStep(
                    user01,
                    itemList.get(i),
                    4,
                    new GregorianCalendar(2023, Calendar.FEBRUARY, 27),
                    new GregorianCalendar(2023, Calendar.MARCH, 14)).run();

        }
        new LogoutStep(user01).run();
    }
}