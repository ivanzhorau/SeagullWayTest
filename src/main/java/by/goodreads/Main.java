package by.goodreads;

import by.goodreads.Components.TableItemComponent;
import by.goodreads.Components.WindowBoxComponent;
import by.goodreads.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.goodreads.com/");

        StartPage home = new StartPage(driver);
        home.clickSignIn();

        new SelectSignInTypePage(driver).clickSignInByEmail();

        SignInByEmailPage signInPage = new SignInByEmailPage(driver);
        signInPage.enterEmail("ivanzhuraulievich@gmail.com");
        signInPage.enterPassword("233422");
        signInPage.clickSignIn();

        BasicHomePage homePage = new BasicHomePage(driver);
        homePage.enterTextToSearchBox("Best crime and mystery books");
        homePage.clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        List<TableItemComponent> itemList = searchPage.getTableItems();
        for(int i = 1; i<2; i++){
            itemList.get(i).clickWantToRead();
            itemList.get(i).markAsRead();
            WindowBoxComponent windowBox = searchPage.getWindowBox();
            windowBox.waitForLoad();
            windowBox.getRateComponent().setRate(4);
            windowBox.getStartReadingDateComponent().setDate("2023","February","27");
            windowBox.getEndReadingDateComponent().setDate("2023","March","14");
            windowBox.clickPost();
        }
        driver.close();
    }
}