package by.goodreads.pages;

import org.openqa.selenium.WebDriver;

//Базовый класс для всех страниц
public abstract class Page {
    private final WebDriver driver;
    public Page(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
