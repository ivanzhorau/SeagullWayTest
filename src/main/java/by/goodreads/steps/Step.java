package by.goodreads.steps;

public abstract class Step {

    private Role role = Role.ACTION;

    public abstract void run() throws Throwable;

    public void execute() throws Throwable {
        try {
            System.out.printf("     Step: '%s' started%n", getSummary());
            run();
            System.out.printf("     Step: '%s' completed successfully%n", getSummary());
        } catch (Throwable e) {
            System.out.printf("     Step: '%s' failed%n", getSummary());
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
                e.printStackTrace();
            }
        },
        CLEANUP {
            @Override
            public void process(Throwable e) throws Throwable {
                throw e;
            }
        };

        public abstract void process(Throwable e) throws Throwable;
    }
}
