package by.goodreads.steps;

public abstract class Step {

    public abstract void run();

    public void runAsCheck() {
        try {
            run();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
