package by.goodreads.steps;

import by.goodreads.User;
import by.goodreads.components.TableItemComponent;
import by.goodreads.components.WindowBoxComponent;
import by.goodreads.pages.BasicHomePage;

import java.util.Calendar;

public class MarkBookAsReadStep extends Step {
    private final User user;
    private final TableItemComponent tableItemComponent;
    private final Integer rate;
    private final Calendar startReadingDate;
    private final Calendar endReadingDate;

    public MarkBookAsReadStep(User user, TableItemComponent tableItemComponent, Integer rate, Calendar startReadingDate, Calendar endReadingDate) {
        this.user = user;
        this.tableItemComponent = tableItemComponent;
        this.rate = rate;
        this.startReadingDate = startReadingDate;
        this.endReadingDate = endReadingDate;
    }

    @Override
    public void run() {
        tableItemComponent.markAsRead();
        WindowBoxComponent windowBox = new BasicHomePage(user.getDriver()).getWindowBox();
        windowBox.waitForLoad();
        windowBox.getRateComponent().setRate(rate);
        windowBox.getStartReadingDateComponent().setDate(startReadingDate);
        windowBox.getEndReadingDateComponent().setDate(endReadingDate);
        windowBox.clickPost();
        windowBox.waitForClose();
    }
}
