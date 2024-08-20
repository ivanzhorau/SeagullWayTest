package by.goodreads.steps.checks;

import by.goodreads.components.TableItemComponent;
import by.goodreads.steps.Step;
import dev.failsafe.internal.util.Assert;

public class CheckBookMarkedAsWantToRead extends Step {
    private final TableItemComponent tableItemComponent;

    public CheckBookMarkedAsWantToRead(TableItemComponent tableItemComponent) {
        this.tableItemComponent = tableItemComponent;
        setRole(Role.CHECK);
    }

    @Override
    public void run() throws Throwable {
        Assert.isTrue(tableItemComponent.getReadStatus().contains("Want to Read"), "Book is not marked as 'WantToRead'");
    }
}
