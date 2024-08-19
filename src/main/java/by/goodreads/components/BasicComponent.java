package by.goodreads.components;

import org.openqa.selenium.WebElement;

//Некоторые элементы встречаются довольно часто и(или) имеют много внутренних компонентов.
//Лучше создавать под их отдельные классы
public abstract class BasicComponent {
    private final WebElement parentElement;
    public BasicComponent(WebElement parentElement){
        this.parentElement=parentElement;
    }

    public WebElement getParentElement() {
        return parentElement;
    }
}
