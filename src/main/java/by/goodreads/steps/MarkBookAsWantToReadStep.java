package by.goodreads.steps;

import by.goodreads.components.TableItemComponent;

public class MarkBookAsWantToReadStep extends Step{

    private final TableItemComponent tableItemComponent;

    public MarkBookAsWantToReadStep(TableItemComponent tableItemComponent){
        this.tableItemComponent = tableItemComponent;
    }

    @Override
    public void run() {
        tableItemComponent.clickWantToRead();
    }
}
