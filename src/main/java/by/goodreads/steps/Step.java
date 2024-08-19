package by.goodreads.steps;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Step {

    private Role role = Role.ACTION;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public abstract void run() throws Throwable;

    public void execute() throws Throwable {
        try {
            logger.log(Level.INFO, String.format("Step: '%s' started%n", getSummary()));
            run();
            logger.log(Level.INFO, String.format("Step: '%s' completed successfully%n", getSummary()));
        } catch (Throwable e) {
            logger.log(Level.INFO, String.format("Step: '%s' failed%n", getSummary()));
            role.process(e);
        }
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSummary() {
        return this.getClass().getName();
    }

    public Role getRole() {
        return role;
    }

    public void skip() {
        logger.log(Level.INFO, String.format("Step: '%s' skipped %n", getSummary()));
    }

    public enum Role {
        ACTION {  //В случае ошибки пропускает выполнение последующих степов в сценарии. Может быть пропущен сам

            @Override
            public void process(Throwable e) throws Throwable {
                throw e;
            }
        },
        CHECK {  //В случае ошибки просто пропускается не воздействуя на другие степы. Может быть пропущен

            @Override
            public void process(Throwable e) {
                logger.log(Level.WARNING, e.toString());

            }
        },
        CLEANUP { //В случае ошибки пропускает выполнение последующих степов в сценарии. Выполняется в любом случае

            @Override
            public void process(Throwable e) throws Throwable {
                throw e;
            }
        };

        private static final Logger logger = Logger.getLogger(Role.class.getName());

        public abstract void process(Throwable e) throws Throwable;
    }
}
