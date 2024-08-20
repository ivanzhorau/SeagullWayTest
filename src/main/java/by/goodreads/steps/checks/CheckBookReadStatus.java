package by.goodreads.steps.checks;

import by.goodreads.components.TableItemComponent;
import by.goodreads.steps.Step;
import dev.failsafe.internal.util.Assert;

public class CheckBookReadStatus extends Step {
    private final TableItemComponent tableItemComponent;
    private final String readStatus;

    public CheckBookReadStatus(TableItemComponent tableItemComponent, String readStatus) {
        this.tableItemComponent = tableItemComponent;
        this.readStatus = readStatus;
        setRole(Role.CHECK);
    }

    @Override
    public void run() throws Throwable {
        Assert.isTrue(tableItemComponent.getReadStatus().contains(readStatus), String.format("Book is not marked as '%s'", readStatus));
    }
}
