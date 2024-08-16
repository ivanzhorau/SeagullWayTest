package by.goodreads.Components;

import org.openqa.selenium.WebElement;

public abstract class BasicComponent {
    private final WebElement parentElement;
    public BasicComponent(WebElement parentElement){
        this.parentElement=parentElement;
    }

    public WebElement getParentElement() {
        return parentElement;
    }
}
