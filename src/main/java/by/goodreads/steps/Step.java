package by.goodreads.steps;

import by.goodreads.scripts.Script;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Step {

    private Role role = Role.ACTION;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public abstract void run() throws Throwable;

    public void execute() throws Throwable {
        try {
            logger.log(Level.INFO,String.format("Step: '%s' started%n", getSummary()));
            run();
            logger.log(Level.INFO,String.format("Step: '%s' completed successfully%n", getSummary()));
        } catch (Throwable e) {
            logger.log(Level.INFO,String.format("Step: '%s' failed%n", getSummary()));
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
        System.out.printf("     Step: '%s' skipped %n", getSummary());
    }

    public enum Role {
        ACTION {
            @Override
            public void process(Throwable e) throws Throwable {
                throw e;
            }
        },
        CHECK {
            @Override
            public void process(Throwable e) {
                logger.log(Level.WARNING, e.toString());

            }
        },
        CLEANUP {
            @Override
            public void process(Throwable e) throws Throwable {
                throw e;
            }
        };

        private static final Logger logger = Logger.getLogger(Role.class.getName());
        public abstract void process(Throwable e) throws Throwable;
    }
}
