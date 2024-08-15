package by.goodreads;

import by.goodreads.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.goodreads.com/");
        HomePage home = new HomePage(driver);
        home.clickSignIn();
        driver.close();
    }
}