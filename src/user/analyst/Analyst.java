package user.analyst;

import user.User;

public class Analyst extends User {

    private int resolvedTickets;
    private int openedTickets;
    private int overDueTickets;
    private int analyst;

    public Analyst(String firstName, String lastName, String email, String id, String userName) {
        super(firstName, lastName, email, id, userName);
        this.analyst = 1;
    }

}
