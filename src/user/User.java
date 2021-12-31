package user;

public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String userId;
    protected String userName;

    public User(){

    }

    public User(String firstName, String lastName, String email, String userId, String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName){
        this.userName = userName;
    }

    public void createUser() throws Exception {
        UserTable.createUser(this);
    }
}
