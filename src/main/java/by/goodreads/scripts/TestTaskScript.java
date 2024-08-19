package by.goodreads.scripts;

import by.goodreads.Holder;
import by.goodreads.User;
import by.goodreads.components.TableItemComponent;
import by.goodreads.steps.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class TestTaskScript extends Script {
    private final User user01;
    private final User user02;
    private final Holder<List<TableItemComponent>> holder = new Holder<>();
    public TestTaskScript(WebDriver driver) {
        user01 = User.loadUserFromFile("src/main/resources/users.json", "user1", driver);
        user02 = User.loadUserFromFile("src/main/resources/users.json", "user_wrong_password", driver);

        List<Step> steps = new ArrayList<>();
        steps.add(new GoToUrlStep(driver, "https://www.goodreads.com/"));
        steps.add(new LoginStep(user02));
        steps.add(new GoToUrlStep(driver, "https://www.goodreads.com/"));
        steps.add(new LoginStep(user01));
        steps.add(new SearchStep(user01, "Best crime and mystery books"));
        steps.add(new GetTableItemsStep(user01, holder));
        steps.add(markBooksAsWantToRead());
        steps.add(markAsRead());
        steps.add(new LogoutStep(user01));

        setSteps(steps);
    }

    private Step markBooksAsWantToRead(){
        return new Step() {
            @Override
            public void run() throws Throwable {
                List<TableItemComponent> itemList = holder.getValue();
                for (int i = 0; i < 3; i++) {
                    new MarkBookAsWantToReadStep(itemList.get(i)).execute();
                }
            }

            @Override
            public String getSummary() {
                return "Mark top 3 books as 'Want to read'";
            }
        };
    }

    private Step markAsRead(){
        return new Step() {
            @Override
            public void run() throws Throwable {
                List<TableItemComponent> itemList = holder.getValue();
                for (int i = 0; i < 3; i++) {
                    new MarkBookAsReadStep(
                            user01,
                            itemList.get(i),
                            4,
                            new GregorianCalendar(2023, Calendar.FEBRUARY, 27),
                            new GregorianCalendar(2023, Calendar.MARCH, 14)).execute();

                }
            }

            @Override
            public String getSummary() {
                return "Mark as read. Rate and leave feedback for them (add different read dates)";
            }
        };
    }

    @Override
    public String getSummary() {
        return "Test task for the position of QA Engineer at Seagull Way";
    }
}
