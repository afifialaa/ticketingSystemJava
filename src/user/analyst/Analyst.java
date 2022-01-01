package user.analyst;

import database.AnalystTable;
import user.User;

public class Analyst extends User {

    private int resolvedTickets;
    private boolean analyst;

    public Analyst(){

    }

    public Analyst(String firstName, String lastName, String email, String userName) {
        super(firstName, lastName, email, userName);
        this.resolvedTickets = 0;
        this.analyst = true;
    }

    public void setAnalyst(boolean analyst){
        this.analyst = analyst;
    }

    public boolean getAnalyst(){
        return analyst;
    }

    public int getResolvedTickets() {
        return resolvedTickets;
    }

    public void setResolvedTickets(int resolvedTickets) {
        this.resolvedTickets = resolvedTickets;
    }

    @Override
    public void create() throws Exception {
        AnalystTable.create(this);
    }

    public void update() {}

    public Analyst read() throws Exception {
        return AnalystTable.read(userName);
    }

    public void delete() throws Exception {
        AnalystTable.delete(userName);
    }

}
