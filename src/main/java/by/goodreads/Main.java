package by.goodreads;

import by.goodreads.scripts.CleanupScript;
import by.goodreads.scripts.TestTaskScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Думаю что стоит остановиться на этом. Кажется, я и так перемудрил немного
public class Main {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        new TestTaskScript(driver).execute();
        new CleanupScript(driver).execute();
        driver.close();
    }
}