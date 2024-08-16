package by.goodreads.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.Date;

public class DatePickerComponent extends BasicComponent{
    private static final By yearSelectButton = By.cssSelector("select[class *= 'Year']");
    private static final By monthSelectButton = By.cssSelector("select[class *= 'Month']");
    private static final By daySelectButton = By.cssSelector("select[class *= 'Day']");
    public DatePickerComponent(WebElement parentElement) {
        super(parentElement);
    }

    private void selectYear(String year){
        getParentElement().findElement(yearSelectButton).click();
        getParentElement().findElement(yearSelectButton).findElement(By.xpath("option[text()='"+year+"']")).click();
    }
    private void selectMonth(String month){
        getParentElement().findElement(monthSelectButton).click();
        getParentElement().findElement(monthSelectButton).findElement(By.xpath("option[text()='"+month+"']")).click();
    }
    private void selectDay(String day){
        getParentElement().findElement(daySelectButton).click();
        getParentElement().findElement(daySelectButton).findElement(By.xpath("option[text()='"+day+"']")).click();
    }

    public void setDate(String year, String month, String day){
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }
}
