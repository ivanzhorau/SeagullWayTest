package by.goodreads.scripts;

import by.goodreads.User;
import by.goodreads.steps.actions.GoToUrlStep;
import by.goodreads.steps.actions.LoginStep;
import by.goodreads.steps.actions.LogoutStep;
import by.goodreads.steps.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

//Сделал по-быстрому, чтобы удалять книги из "My Books". Думаю лишним не будет
public class CleanupScript extends Script {

    public CleanupScript(WebDriver driver) {
        User user01 = User.loadUserFromFile("src/main/resources/users.json", "user1", driver);

        List<Step> steps = new ArrayList<>();
        steps.add(new GoToUrlStep(driver, "https://www.goodreads.com/"));
        steps.add(new LoginStep(user01));
        steps.add(new Step() {
            @Override
            public void run() {
                driver.findElement(By.cssSelector(".siteHeader__primaryNavInline > ul:nth-child(1) > li:nth-child(2)")).click();
                driver.findElements(By.cssSelector("a.deleteLink")).forEach(webElement -> {
                    webElement.click();
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                });
            }

            @Override
            public String getSummary() {
                return "Delete books from 'My Books'";
            }
        });
        steps.add(new LogoutStep(user01));
        setSteps(steps);
    }
}
