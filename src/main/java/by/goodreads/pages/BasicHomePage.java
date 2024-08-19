package by.goodreads.pages;

import by.goodreads.components.WindowBoxComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Базовый класс для страниц залогиненого пользователя. Описаны элементы с шапки сайта
public class BasicHomePage extends Page{
    private static final By searchBoxInput = By.cssSelector(".searchBox__input--navbar");
    private static final By searchBoxButton = By.cssSelector(".searchBox__icon--navbar");
    private static final By windowBox = By.cssSelector("#box");
    private static final By profileMenuButton = By.cssSelector(".siteHeader__personal .dropdown--profileMenu");
    private static final By signOutButton = By.cssSelector("div.siteHeader__subNav li[role*='Sign out']");

    public BasicHomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchBox(String text){
        getDriver().findElement(searchBoxInput).sendKeys(text);
    }

    public void clickSearchButton(){
        getDriver().findElement(searchBoxButton).click();
    }

    //Поместил это сюда, так как WindowBox встречается на разных страницах сайта
    public WindowBoxComponent getWindowBox(){
        return new WindowBoxComponent(getDriver().findElement(windowBox));
    }

    public void clickProfileMenu(){
        getDriver().findElement(profileMenuButton).click();
    }

    public void clickSignOut(){
        getDriver().findElement(signOutButton).click();
    }
}
