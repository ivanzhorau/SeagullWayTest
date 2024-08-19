package by.goodreads;

import by.goodreads.scripts.CleanupScript;
import by.goodreads.scripts.TestTaskScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) throws Throwable {
        WebDriver driver = new FirefoxDriver();
        goodReadsFlow(driver);
        cleanup(driver);
        driver.close();
    }

    private static void cleanup(WebDriver driver) throws Throwable {
        new CleanupScript(driver).execute();
    }

    private static void goodReadsFlow(WebDriver driver) throws Throwable {
        new TestTaskScript(driver).execute();
    }
}