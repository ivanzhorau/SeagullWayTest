package by.goodreads.steps.actions;

import by.goodreads.components.TableItemComponent;
import by.goodreads.steps.Step;

public class MarkBookAsWantToReadStep extends Step {

    private final TableItemComponent tableItemComponent;

    public MarkBookAsWantToReadStep(TableItemComponent tableItemComponent){
        this.tableItemComponent = tableItemComponent;
    }

    @Override
    public void run() {
        tableItemComponent.clickWantToRead();
    }
}
