package by.goodreads.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

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

    public void setDate(Calendar date){
        selectYear(String.valueOf(date.get(Calendar.YEAR)));
        selectMonth(new DateFormatSymbols(Locale.ENGLISH).getMonths()[date.get(Calendar.MONTH)]);
        selectDay(String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
    }
}
